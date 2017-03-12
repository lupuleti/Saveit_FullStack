package com.studenthackv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class JobResults {

  private String jobId;
  private String status;
  private String freeCredits;
  private String paidCredits;
  private List<ExternalProduct> products;

  public JobResults() {
  }

  public JobResults(
      String jobId,
      String status,
      String freeCredits,
      String paidCredits,
      List<ExternalProduct> products) {
    this.jobId = jobId;
    this.status = status;
    this.freeCredits = freeCredits;
    this.paidCredits = paidCredits;
    this.products = products;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getFreeCredits() {
    return freeCredits;
  }

  public void setFreeCredits(String freeCredits) {
    this.freeCredits = freeCredits;
  }

  public String getPaidCredits() {
    return paidCredits;
  }

  public void setPaidCredits(String paidCredits) {
    this.paidCredits = paidCredits;
  }

  public List<ExternalProduct> getProducts() {
    return products;
  }

  public void setProducts(List<ExternalProduct> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    JobResults that = (JobResults) o;

    if (jobId != null ? !jobId.equals(that.jobId) : that.jobId != null) {
      return false;
    }
    if (status != null ? !status.equals(that.status) : that.status != null) {
      return false;
    }
    if (freeCredits != null ? !freeCredits.equals(that.freeCredits) : that.freeCredits != null) {
      return false;
    }
    if (paidCredits != null ? !paidCredits.equals(that.paidCredits) : that.paidCredits != null) {
      return false;
    }
    return products != null ? products.equals(that.products) :
        that.products == null;

  }

  @Override
  public int hashCode() {
    int result = jobId != null ? jobId.hashCode() : 0;
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (freeCredits != null ? freeCredits.hashCode() : 0);
    result = 31 * result + (paidCredits != null ? paidCredits.hashCode() : 0);
    result = 31 * result + (products != null ? products.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("JobResults{");
    sb.append("jobId='").append(jobId).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append(", freeCredits='").append(freeCredits).append('\'');
    sb.append(", paidCredits='").append(paidCredits).append('\'');
    sb.append(", products=").append(products);
    sb.append('}');
    return sb.toString();
  }
}
