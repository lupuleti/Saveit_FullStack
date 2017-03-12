package com.studenthackv.controller;

import com.studenthackv.model.Customer;
import com.studenthackv.model.Job;
import com.studenthackv.model.JobResults;
import com.studenthackv.model.Product;
import com.studenthackv.provider.PriceApiProvider;
import com.studenthackv.repository.CustomerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

  private CustomerRepository customerRepository;
  private PriceApiProvider priceApiProvider;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  public CustomerResource(CustomerRepository customerRepository, PriceApiProvider priceApiProvider) {
    this.customerRepository = customerRepository;
    this.priceApiProvider = priceApiProvider;
  }

    @RequestMapping(value = "/emailAddress/{emailAddress}"
        , method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity getCustomerByEmailAddress(
        @PathVariable String emailAddress) {

      try {
        Customer customer = customerRepository.getCustomerByEmailAddress(emailAddress);

        Product product = new Product();
        JobResults productPrices = priceApiProvider.getProductPrices("iphone 7 32GB");
        System.out.println(productPrices);
        return ResponseEntity.ok(productPrices);
      } catch (Exception e) {
        logger.error("Unable to get customer, ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
      }
    }

  @RequestMapping(value = "/customer-list"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getCustomerList() {
    try {
      List<Customer> customerList = customerRepository.getCustomerList();
      return ResponseEntity.ok(customerList);
    } catch (Exception e) {
      logger.error("Unable to get customer list, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
}
