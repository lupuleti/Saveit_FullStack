package com.studenthackv.controller;

import com.studenthackv.model.LastWeekStatistics;
import com.studenthackv.model.Offer;
import com.studenthackv.model.Product;
import com.studenthackv.model.Purchase;
import com.studenthackv.provider.PriceApiProvider;
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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ApiResource {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private PriceApiProvider priceApiProvider;
  private ProductRepository productRepository;
  private PurchaseRepository purchaseRepository;
  private ApiService apiService;

  @Autowired
  public ApiResource(
      PriceApiProvider priceApiProvider,
      ProductRepository productRepository,
      PurchaseRepository purchaseRepository, ApiService apiService) {
    this.priceApiProvider = priceApiProvider;
    this.productRepository = productRepository;
    this.purchaseRepository = purchaseRepository;
    this.apiService = apiService;
  }

  @RequestMapping(value = "/offers/product-title/{productTitle}"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getOffersByProductTitle(
      @PathVariable String productTitle) {
    try {
      List<Offer> offerList = apiService.getOfferList(productTitle);
      return ResponseEntity.ok(offerList);
    } catch (Exception e) {
      logger.error("Unable to get customer, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }


  @RequestMapping(value = "/good-deal/{productId}"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity isGoodDeal(
      @PathVariable int productId) {
    try {
      Product product = productRepository.getProductByProductId(productId);
      List<Offer> offerList = apiService.getOfferList(product.getTitle());

      Offer offerFound = offerList.stream()
          .filter(offer -> offer.getPrice() < product.getPrice()).findAny().orElse(null);

      return ResponseEntity.ok(offerFound != null);
    } catch (Exception e) {
      logger.error("Unable to get customer, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @RequestMapping(value = "/last-week-savings"
      , method = RequestMethod.GET)
  @CrossOrigin(origins = "http://localhost:3000")
  public ResponseEntity getLastWeekSavings() {
    List<Double> paidPricePerDay = new ArrayList<>();
    List<Double> minimumPricePerDay = new ArrayList<>();
    try {
      List<Purchase> purchaseList = purchaseRepository.getPurchaseListByEmailAddress("test@test");
      Map<Integer, List<Product>> dayToProductsBought = new HashMap<>();
      for (Purchase purchase : purchaseList) {
        for (int day = 1; day <= 7; day++) {
          if (purchase.getPurchaseDate().dayOfWeek().get() == day) {
            dayToProductsBought.put(day,
                productRepository.getProductListByPurchaseId(purchase.getPurchaseId()));
          }
        }

        Double paidSum = 0.0;
        Double minimumSum = 0.0;
        for (int day = 1; day <= 7; day++) {
          if (dayToProductsBought.get(day) != null) {
            for (Product product : dayToProductsBought.get(day)) {
              List<Offer> offerList = apiService.getOfferList(product.getTitle());
              Offer bestOffer = null;
              try {
                bestOffer = offerList.stream().min(Comparator.comparingDouble(Offer::getPrice)).orElseThrow(
                    NoSuchElementException::new);
                minimumSum = minimumSum + bestOffer.getPrice();
              } catch (NoSuchElementException ex) {
                logger.error("Found one without a price.");
              }
              paidSum = paidSum + product.getPrice();

            }
            paidPricePerDay.add(paidSum);
            minimumPricePerDay.add(minimumSum);
          }
        }
      }

      return ResponseEntity.ok(new LastWeekStatistics(paidPricePerDay, minimumPricePerDay));
    } catch (Exception e) {
      logger.error("Unable to get customer, ", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }


}
