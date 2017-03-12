package com.studenthackv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties
public class Job {

  private String jobId;
  private String status;
  private String country;
  private String source;
  private String createdAt;
  private int requested;

  public Job() {
  }

  public Job(
      String jobId,
      String status,
      String country,
      String source,
      String createdAt,
      int requested) {
    this.jobId = jobId;
    this.status = status;
    this.country = country;
    this.source = source;
    this.createdAt = createdAt;
    this.requested = requested;
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

  public int getRequested() {
    return requested;
  }

  public void setRequested(int requested) {
    this.requested = requested;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Job job = (Job) o;

    if (requested != job.requested) {
      return false;
    }
    if (jobId != null ? !jobId.equals(job.jobId) : job.jobId != null) {
      return false;
    }
    if (status != null ? !status.equals(job.status) : job.status != null) {
      return false;
    }
    if (country != null ? !country.equals(job.country) : job.country != null) {
      return false;
    }
    if (source != null ? !source.equals(job.source) : job.source != null) {
      return false;
    }
    return createdAt != null ? createdAt.equals(job.createdAt) : job.createdAt == null;

  }

  @Override
  public int hashCode() {
    int result = jobId != null ? jobId.hashCode() : 0;
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (source != null ? source.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + requested;
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Job{");
    sb.append("jobId='").append(jobId).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append(", country='").append(country).append('\'');
    sb.append(", source='").append(source).append('\'');
    sb.append(", createdAt='").append(createdAt).append('\'');
    sb.append(", requested=").append(requested);
    sb.append('}');
    return sb.toString();
  }
}
