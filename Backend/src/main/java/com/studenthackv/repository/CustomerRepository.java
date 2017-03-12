package com.studenthackv.repository;

import com.studenthackv.model.Customer;

import java.util.List;

public interface CustomerRepository {
  
  Customer getCustomerByEmailAddress(String emailAddress) throws Exception;
  
  List<Customer> getCustomerList() throws Exception;
}
