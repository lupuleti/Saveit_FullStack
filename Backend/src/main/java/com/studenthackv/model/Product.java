package com.studenthackv.model;

public class Product {

  private int productId;
  private int purchaseId;
  private double price;
  private String title;
  private String brand;
  private boolean isGoodDeal;

  public Product() {
  }

  public Product(
      int productId,
      int purchaseId,
      double price,
      String title,
      String brand) {
    this.productId = productId;
    this.purchaseId = purchaseId;
    this.price = price;
    this.title = title;
    this.brand = brand;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getPurchaseId() {
    return purchaseId;
  }

  public void setPurchaseId(int purchaseId) {
    this.purchaseId = purchaseId;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public boolean isGoodDeal() {
    return isGoodDeal;
  }

  public void setGoodDeal(boolean goodDeal) {
    isGoodDeal = goodDeal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Product product = (Product) o;

    if (productId != product.productId) {
      return false;
    }
    if (purchaseId != product.purchaseId) {
      return false;
    }
    if (Double.compare(product.price, price) != 0) {
      return false;
    }
    if (isGoodDeal != product.isGoodDeal) {
      return false;
    }
    if (title != null ? !title.equals(product.title) : product.title != null) {
      return false;
    }
    return brand != null ? brand.equals(product.brand) : product.brand == null;

  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = productId;
    result = 31 * result + purchaseId;
    temp = Double.doubleToLongBits(price);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (brand != null ? brand.hashCode() : 0);
    result = 31 * result + (isGoodDeal ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Product{");
    sb.append("productId=").append(productId);
    sb.append(", purchaseId=").append(purchaseId);
    sb.append(", price=").append(price);
    sb.append(", title='").append(title).append('\'');
    sb.append(", brand='").append(brand).append('\'');
    sb.append(", isGoodDeal=").append(isGoodDeal);
    sb.append('}');
    return sb.toString();
  }
}
