package com.studenthackv;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class InformationProvider {

  private RestTemplate restTemplate;


  @Autowired
  public InformationProvider(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity getInformation() {

    String url = "http://google.com";
    String forObject = restTemplate.getForObject(url, String.class);

    return ResponseEntity.ok(forObject);

  }

}
