package com.studenthackv.model;

import org.joda.time.DateTime;

public class Purchase {

  private int purchaseId;
  private String emailAddress;
  private DateTime purchaseDate;
  private double totalValue;
  private String retailer;

  public Purchase(
      int purchaseId,
      String emailAddress,
      DateTime purchaseDate,
      double totalValue,
      String retailer) {
    this.purchaseId = purchaseId;
    this.emailAddress = emailAddress;
    this.purchaseDate = purchaseDate;
    this.totalValue = totalValue;
    this.retailer = retailer;
  }

  public int getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(int purchaseId) {
    this.purchaseId = purchaseId;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public DateTime getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(DateTime purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(double totalValue) {
    this.totalValue = totalValue;
  }

  public String getRetailer() {
    return retailer;
  }

  public void setRetailer(String retailer) {
    this.retailer = retailer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Purchase purchase = (Purchase) o;

    if (purchaseId != purchase.purchaseId) {
      return false;
    }
    if (Double.compare(purchase.totalValue, totalValue) != 0) {
      return false;
    }
    if (emailAddress != null ? !emailAddress.equals(purchase.emailAddress) :
        purchase.emailAddress != null) {
      return false;
    }
    if (purchaseDate != null ? !purchaseDate.equals(purchase.purchaseDate) :
        purchase.purchaseDate != null) {
      return false;
    }
    return retailer != null ? retailer.equals(purchase.retailer) : purchase.retailer == null;

  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = purchaseId;
    result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
    result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
    temp = Double.doubleToLongBits(totalValue);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (retailer != null ? retailer.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Purchase{");
    sb.append("purchaseId=").append(purchaseId);
    sb.append(", emailAddress='").append(emailAddress).append('\'');
    sb.append(", purchaseDate=").append(purchaseDate);
    sb.append(", totalValue=").append(totalValue);
    sb.append(", retailer='").append(retailer).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
