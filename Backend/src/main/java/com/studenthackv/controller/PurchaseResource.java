package com.studenthackv.controller;

import com.studenthackv.model.Purchase;
import com.studenthackv.repository.PurchaseRepository;

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
@RequestMapping("/purchase")
public class PurchaseResource {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private PurchaseRepository purchaseRepository;

  @Autowired
  public PurchaseResource(PurchaseRepository purchaseRepository) {
    this.purchaseRepository = purchaseRepository;
  }

  @RequestMapping(value = "purchase-id/{purchaseId}"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getPurchaseByPurchaseId(
      @PathVariable int purchaseId) {
    try {
      Purchase purchase = purchaseRepository.getPurchaseByPurchaseId(purchaseId);
      return ResponseEntity.ok(purchase);
    } catch (Exception e) {
      logger.error("Unable to get purchase, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @RequestMapping(value = "emailAddress/{emailAddress}"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getPurchaseListByEmailAddress(
      @PathVariable String emailAddress) {
    try {
      List<Purchase> purchaseList = purchaseRepository.getPurchaseListByEmailAddress(emailAddress);
      return ResponseEntity.ok(purchaseList);
    } catch (Exception e) {
      logger.error("Unable to get purchase list, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
