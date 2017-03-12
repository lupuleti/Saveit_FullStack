package com.studenthackv.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Offer {

  private String shopName;
  private double price;
  private double priceWithShippingCosts;
  private String currency;
  private String name;
  private String url;


  public Offer() {
  }

  public Offer(
      String shopName,
      double price,
      double priceWithShippingCosts,
      String currency, String name, String url) {
    this.shopName = shopName;
    this.price = price;
    this.priceWithShippingCosts = priceWithShippingCosts;
    this.currency = currency;
    this.name = name;
    this.url = url;
  }

  public String getShopName() {
    return shopName;
  }

  public void setShopName(String shopName) {
    this.shopName = shopName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getPriceWithShippingCosts() {
    return priceWithShippingCosts;
  }

  public void setPriceWithShippingCosts(double priceWithShippingCosts) {
    this.priceWithShippingCosts = priceWithShippingCosts;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Offer offer = (Offer) o;

    if (Double.compare(offer.price, price) != 0) {
      return false;
    }
    if (Double.compare(offer.priceWithShippingCosts, priceWithShippingCosts) != 0) {
      return false;
    }
    if (shopName != null ? !shopName.equals(offer.shopName) : offer.shopName != null) {
      return false;
    }
    if (currency != null ? !currency.equals(offer.currency) : offer.currency != null) {
      return false;
    }
    if (name != null ? !name.equals(offer.name) : offer.name != null) {
      return false;
    }
    return url != null ? url.equals(offer.url) : offer.url == null;

  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Offer{");
    sb.append("shopName='").append(shopName).append('\'');
    sb.append(", price=").append(price);
    sb.append(", priceWithShippingCosts=").append(priceWithShippingCosts);
    sb.append(", currency='").append(currency).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", url='").append(url).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
