package com.studenthackv.model;

public class Customer {

  private String email_address;
  private String name;
  private String address;
  private String phoneNumber;

  public Customer(String email_address, String name, String address, String phoneNumber) {
    this.email_address = email_address;
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public String getEmail_address() {
    return email_address;
  }

  public void setEmail_address(String email_address) {
    this.email_address = email_address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Customer customer = (Customer) o;

    if (email_address != null ? !email_address.equals(customer.email_address) :
        customer.email_address != null) {
      return false;
    }
    if (name != null ? !name.equals(customer.name) : customer.name != null) {
      return false;
    }
    if (address != null ? !address.equals(customer.address) : customer.address != null) {
      return false;
    }
    return phoneNumber != null ? phoneNumber.equals(customer.phoneNumber) :
        customer.phoneNumber == null;

  }

  @Override
  public int hashCode() {
    int result = email_address != null ? email_address.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Customer{");
    sb.append("email_address='").append(email_address).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append(", address='").append(address).append('\'');
    sb.append(", phoneNumber='").append(phoneNumber).append('\'');
    sb.append('}');
    return sb.toString();
  }
}

