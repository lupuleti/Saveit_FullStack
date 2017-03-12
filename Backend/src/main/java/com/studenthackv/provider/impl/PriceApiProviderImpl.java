package com.studenthackv.provider.impl;

import com.studenthackv.model.Job;
import com.studenthackv.model.JobResults;
import com.studenthackv.model.JobStatus;
import com.studenthackv.provider.PriceApiProvider;
import com.studenthackv.repository.ApiRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PriceApiProviderImpl implements PriceApiProvider {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final RestTemplate restTemplate;
  private final ApiRepository apiRepository;
  private final String priceApiUrl;
  private final String securityToken;
  private final int refreshInterval;


  private final String jobPath = "jobs";
  private final String jobStatusPath = "jobs/{jobId}?token={token}";
  private final String jobResultsPath = "products/bulk/{jobId}?token={token}";

  @Autowired
  public PriceApiProviderImpl(
      @Value("${price-api.location}") String priceApiUrl,
      @Value("${security.token}") String securityToken,
      @Value("${refresh.interval}") int refreshInterval,
      RestTemplate restTemplate, ApiRepository apiRepository) {
    this.restTemplate = restTemplate;
    this.priceApiUrl = priceApiUrl;
    this.securityToken = securityToken;
    this.refreshInterval = refreshInterval;
    this.apiRepository = apiRepository;
  }

  @Override
  public JobResults getProductPrices(String productTitle) throws Exception {
    try {
      String jobId = apiRepository.getApiCaching(productTitle);
      if (StringUtils.isEmpty(jobId)) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        Map req_payload = new HashMap();

        req_payload.put("token", securityToken);
        req_payload.put("country", "gb");
        req_payload.put("source", "google-shopping");
        req_payload.put("currentness", "daily_updated");
        req_payload.put("completeness", "one_page");
        req_payload.put("key", "keyword");
        req_payload.put("values", productTitle);

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);

        Job job =
            restTemplate.postForEntity(priceApiUrl + jobPath, request, Job.class).getBody();
        logger.info("Start job:" + job);
        boolean done = false;
        while (!done) {
          try {
            Thread.sleep(refreshInterval);
            JobStatus jobStatus = getJobStatusById(job.getJobId());
            logger.info("Job status: " + jobStatus);
            done = jobStatus.getStatus().equals("finished");
          } catch (Exception ex) {
            logger.error("Unable to get job's status for job id:" + job.getJobId());
          }
        }

        try {
          apiRepository.insertApiCaching(productTitle, job.getJobId());
          return getJobResults(job.getJobId());
        } catch (Exception ex) {
          throw new Exception("something went wrong");
        }
      } else {
        try {
          return getJobResults(jobId);
        } catch (Exception ex) {
          throw new Exception("something went wrong");
        }
      }

    } catch (Exception ex) {
      throw new Exception("Something went wrong when getting price results.");
    }
  }

  @Override
  public JobStatus getJobStatusById(String jobId) throws Exception {
    try {
      JobStatus jobStatus =
          restTemplate.getForObject(priceApiUrl + jobStatusPath, JobStatus.class, jobId,
              securityToken);
      return jobStatus;
    } catch (Exception ex) {
      logger.error("Getting job status failed:" + ex);
      throw new Exception("Unable to get job status", ex);
    }
  }

  @Override
  public JobResults getJobResults(String jobId) throws Exception {
    try {
      JobResults jobResults =
          restTemplate.getForObject(priceApiUrl + jobResultsPath, JobResults.class, jobId,
              securityToken);
      logger.info("Job Results" + jobResults);
      return jobResults;
    } catch (Exception ex) {
      throw new Exception("Unable to get job results", ex);
    }
  }
}


