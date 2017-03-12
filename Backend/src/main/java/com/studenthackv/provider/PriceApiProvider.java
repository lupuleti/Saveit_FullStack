package com.studenthackv.provider;

import com.studenthackv.model.JobResults;
import com.studenthackv.model.JobStatus;

public interface PriceApiProvider {
  JobResults getProductPrices(String productTitle) throws Exception;

  JobStatus getJobStatusById(String jobId) throws Exception;

  JobResults getJobResults(String jobId) throws Exception;
}
