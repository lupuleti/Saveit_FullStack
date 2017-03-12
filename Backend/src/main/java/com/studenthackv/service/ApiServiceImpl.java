package com.studenthackv.service;

import com.studenthackv.model.JobResults;
import com.studenthackv.model.Offer;
import com.studenthackv.model.Product;
import com.studenthackv.provider.PriceApiProvider;
import com.studenthackv.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiServiceImpl implements ApiService {

  private final PriceApiProvider priceApiProvider;
  private final ProductRepository productRepository;

  @Autowired
  public ApiServiceImpl(PriceApiProvider priceApiProvider, ProductRepository productRepository) {
    this.priceApiProvider = priceApiProvider;
    this.productRepository = productRepository;
  }

  @Override
  public boolean isGoodDeal(int productId) throws Exception {
    Product product = productRepository.getProductByProductId(productId);
    JobResults jobResults = priceApiProvider.getProductPrices(product.getTitle());

    Offer offerFound = jobResults.getProducts().get(0).getOffers().stream()
        .filter(offer -> offer.getPrice() > product.getPrice()).findAny().orElse(null);

    return offerFound != null;
  }

  @Override
  public List<Offer> getOfferList(String productTitle) throws Exception {
    Product product = productRepository.getProductByProductTitle(productTitle);
    JobResults jobResults = priceApiProvider.getProductPrices(productTitle);

    return jobResults.getProducts().get(0).getOffers().stream()
        .filter(offer -> offer.getPrice() < product.getPrice())
        .collect(Collectors.toList());
  }
}
