package com.studenthackv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class JobStatus {

  private String jobId;
  private String country;
  private String source;
  private String status;
  private int requested;
  private int completed;
  private int refusals;
  private int errors;
  private int progress;
  private String createdAt;
  private String terminatedAt;
  private String downloadedAt;

  public JobStatus() {
  }

  public JobStatus(
      String jobId,
      String country,
      String source,
      String status,
      int requested,
      int completed,
      int refusals,
      int errors,
      int progress,
      String createdAt,
      String terminatedAt, String downloadedAt) {
    this.jobId = jobId;
    this.country = country;
    this.source = source;
    this.status = status;
    this.requested = requested;
    this.completed = completed;
    this.refusals = refusals;
    this.errors = errors;
    this.progress = progress;
    this.createdAt = createdAt;
    this.terminatedAt = terminatedAt;
    this.downloadedAt = downloadedAt;
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

  public int getCompleted() {
    return completed;
  }

  public void setCompleted(int completed) {
    this.completed = completed;
  }

  public int getProgress() {
    return progress;
  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public int getRefusals() {
    return refusals;
  }

  public void setRefusals(int refusals) {
    this.refusals = refusals;
  }

  public int getErrors() {
    return errors;
  }

  public void setErrors(int errors) {
    this.errors = errors;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getTerminatedAt() {
    return terminatedAt;
  }

  public void setTerminatedAt(String terminatedAt) {
    this.terminatedAt = terminatedAt;
  }

  public String getDownloadedAt() {
    return downloadedAt;
  }

  public void setDownloadedAt(String downloadedAt) {
    this.downloadedAt = downloadedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    JobStatus jobStatus = (JobStatus) o;

    if (requested != jobStatus.requested) {
      return false;
    }
    if (completed != jobStatus.completed) {
      return false;
    }
    if (refusals != jobStatus.refusals) {
      return false;
    }
    if (errors != jobStatus.errors) {
      return false;
    }
    if (progress != jobStatus.progress) {
      return false;
    }
    if (jobId != null ? !jobId.equals(jobStatus.jobId) : jobStatus.jobId != null) {
      return false;
    }
    if (country != null ? !country.equals(jobStatus.country) : jobStatus.country != null) {
      return false;
    }
    if (source != null ? !source.equals(jobStatus.source) : jobStatus.source != null) {
      return false;
    }
    if (status != null ? !status.equals(jobStatus.status) : jobStatus.status != null) {
      return false;
    }
    if (createdAt != null ? !createdAt.equals(jobStatus.createdAt) : jobStatus.createdAt != null) {
      return false;
    }
    if (terminatedAt != null ? !terminatedAt.equals(jobStatus.terminatedAt) :
        jobStatus.terminatedAt != null) {
      return false;
    }
    return downloadedAt != null ? downloadedAt.equals(jobStatus.downloadedAt) :
        jobStatus.downloadedAt == null;

  }

  @Override
  public int hashCode() {
    int result = jobId != null ? jobId.hashCode() : 0;
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (source != null ? source.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + requested;
    result = 31 * result + completed;
    result = 31 * result + refusals;
    result = 31 * result + errors;
    result = 31 * result + progress;
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (terminatedAt != null ? terminatedAt.hashCode() : 0);
    result = 31 * result + (downloadedAt != null ? downloadedAt.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("JobStatus{");
    sb.append("jobId='").append(jobId).append('\'');
    sb.append(", country='").append(country).append('\'');
    sb.append(", source='").append(source).append('\'');
    sb.append(", status='").append(status).append('\'');
    sb.append(", requested=").append(requested);
    sb.append(", completed=").append(completed);
    sb.append(", refusals=").append(refusals);
    sb.append(", errors=").append(errors);
    sb.append(", progress=").append(progress);
    sb.append(", createdAt='").append(createdAt).append('\'');
    sb.append(", terminatedAt='").append(terminatedAt).append('\'');
    sb.append(", downloadedAt='").append(downloadedAt).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
