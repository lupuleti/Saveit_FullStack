package com.studenthackv.repository;

import com.studenthackv.model.Product;

import java.util.List;

public interface ProductRepository {

  Product getProductByProductId(int productId) throws Exception;

  Product getProductByProductTitle(String productTitle) throws Exception;

  List<Product> getProductListByPurchaseId(int purchaseId) throws Exception;


}
