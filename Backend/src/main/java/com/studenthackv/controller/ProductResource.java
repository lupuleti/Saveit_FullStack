package com.studenthackv.controller;

import com.studenthackv.model.Product;
import com.studenthackv.repository.ProductRepository;
import com.studenthackv.repository.PurchaseRepository;
import com.studenthackv.service.ApiService;

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
@RequestMapping("/product")
public class ProductResource {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private ProductRepository productRepository;
  private PurchaseRepository purchaseRepository;
  private ApiService apiService;


  @Autowired
  public ProductResource(
      ProductRepository productRepository,
      PurchaseRepository purchaseRepository,
      ApiService apiService) {
    this.productRepository = productRepository;
    this.purchaseRepository = purchaseRepository;
    this.apiService = apiService;
  }

  @RequestMapping(value = "/product-id/{productId}"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getProductByProductId(
      @PathVariable int productId) {
    try {
      Product product = productRepository.getProductByProductId(productId);
      return ResponseEntity.ok(product);
    } catch (Exception e) {
      logger.error("Unable to get product, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @RequestMapping(value = "/purchase-id/{purchaseId}"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getProductListByPurchaseId(
      @PathVariable int purchaseId) {
    try {
      List<Product> productList = productRepository.getProductListByPurchaseId(purchaseId);

      for (Product product : productList) {
        product.setGoodDeal(apiService.isGoodDeal(product.getProductId()));
      }
      return ResponseEntity.ok(productList);
    } catch (Exception e) {
      logger.error("Unable to get product list, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
