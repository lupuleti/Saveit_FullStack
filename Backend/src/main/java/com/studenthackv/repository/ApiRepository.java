package com.studenthackv.repository;

public interface ApiRepository {

  public void insertApiCaching(String productTitle, String jobId) throws Exception;

  public String getApiCaching(String productTitle) throws Exception;
}
