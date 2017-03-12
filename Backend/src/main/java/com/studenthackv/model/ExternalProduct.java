package com.studenthackv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalProduct {

  private String source;
  private String country;
  private String key;
  private String value;
  private boolean success;
  private String updatedAt;
  private String reason;
  private String id;
  private String name;
  private String brandName;
  private String categoryName;
  private int reviewCount;
  private int reviewRating;
  private List<Long> gtinList;
  private String url;
  private List<Offer> offers;

  public ExternalProduct() {
  }

  public ExternalProduct(
      String source,
      String country,
      String key,
      String value,
      boolean success,
      String updatedAt,
      String reason,
      String id,
      String name,
      String brandName,
      String categoryName,
      int reviewCount,
      int reviewRating,
      List<Long> gtinList,
      String url, List<Offer> offers) {
    this.source = source;
    this.country = country;
    this.key = key;
    this.value = value;
    this.success = success;
    this.updatedAt = updatedAt;
    this.reason = reason;
    this.id = id;
    this.name = name;
    this.brandName = brandName;
    this.categoryName = categoryName;
    this.reviewCount = reviewCount;
    this.reviewRating = reviewRating;
    this.gtinList = gtinList;
    this.url = url;
    this.offers = offers;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public int getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(int reviewCount) {
    this.reviewCount = reviewCount;
  }

  public int getReviewRating() {
    return reviewRating;
  }

  public void setReviewRating(int reviewRating) {
    this.reviewRating = reviewRating;
  }

  public List<Long> getGtinList() {
    return gtinList;
  }

  public void setGtinList(List<Long> gtinList) {
    this.gtinList = gtinList;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Offer> getOffers() {
    return offers;
  }

  public void setOffers(List<Offer> offers) {
    this.offers = offers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ExternalProduct that = (ExternalProduct) o;

    if (success != that.success) {
      return false;
    }
    if (reviewCount != that.reviewCount) {
      return false;
    }
    if (reviewRating != that.reviewRating) {
      return false;
    }
    if (source != null ? !source.equals(that.source) : that.source != null) {
      return false;
    }
    if (country != null ? !country.equals(that.country) : that.country != null) {
      return false;
    }
    if (key != null ? !key.equals(that.key) : that.key != null) {
      return false;
    }
    if (value != null ? !value.equals(that.value) : that.value != null) {
      return false;
    }
    if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) {
      return false;
    }
    if (reason != null ? !reason.equals(that.reason) : that.reason != null) {
      return false;
    }
    if (id != null ? !id.equals(that.id) : that.id != null) {
      return false;
    }
    if (name != null ? !name.equals(that.name) : that.name != null) {
      return false;
    }
    if (brandName != null ? !brandName.equals(that.brandName) : that.brandName != null) {
      return false;
    }
    if (categoryName != null ? !categoryName.equals(that.categoryName) :
        that.categoryName != null) {
      return false;
    }
    if (gtinList != null ? !gtinList.equals(that.gtinList) : that.gtinList != null) {
      return false;
    }
    if (url != null ? !url.equals(that.url) : that.url != null) {
      return false;
    }
    return offers != null ? offers.equals(that.offers) : that.offers == null;

  }

  @Override
  public int hashCode() {
    int result = source != null ? source.hashCode() : 0;
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (key != null ? key.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    result = 31 * result + (success ? 1 : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (reason != null ? reason.hashCode() : 0);
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
    result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
    result = 31 * result + reviewCount;
    result = 31 * result + reviewRating;
    result = 31 * result + (gtinList != null ? gtinList.hashCode() : 0);
    result = 31 * result + (url != null ? url.hashCode() : 0);
    result = 31 * result + (offers != null ? offers.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ExternalProduct{");
    sb.append("source='").append(source).append('\'');
    sb.append(", country='").append(country).append('\'');
    sb.append(", key='").append(key).append('\'');
    sb.append(", value='").append(value).append('\'');
    sb.append(", success=").append(success);
    sb.append(", updatedAt='").append(updatedAt).append('\'');
    sb.append(", reason='").append(reason).append('\'');
    sb.append(", id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", brandName='").append(brandName).append('\'');
    sb.append(", categoryName='").append(categoryName).append('\'');
    sb.append(", reviewCount=").append(reviewCount);
    sb.append(", reviewRating=").append(reviewRating);
    sb.append(", gtinList=").append(gtinList);
    sb.append(", url='").append(url).append('\'');
    sb.append(", offers=").append(offers);
    sb.append('}');
    return sb.toString();
  }
}
