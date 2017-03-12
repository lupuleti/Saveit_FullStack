package com.studenthackv.repository;

import com.studenthackv.model.Purchase;

import java.util.List;

public interface PurchaseRepository {

  Purchase getPurchaseByPurchaseId(int purchaseId) throws Exception;

  List<Purchase> getPurchaseListByEmailAddress(String emailAddress) throws Exception;
}
