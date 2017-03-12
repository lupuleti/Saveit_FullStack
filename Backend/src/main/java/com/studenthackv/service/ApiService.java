package com.studenthackv.service;

import com.studenthackv.model.Offer;

import java.util.List;

public interface ApiService {

  public boolean isGoodDeal(int productId) throws Exception;

  public List<Offer> getOfferList(String productTitle) throws Exception;
}
