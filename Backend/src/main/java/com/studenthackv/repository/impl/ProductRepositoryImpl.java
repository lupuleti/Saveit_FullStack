package com.studenthackv.repository.impl;

import com.studenthackv.model.Product;
import com.studenthackv.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public ProductRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static final String SQL_GET_PRODUCT_LIST_BY_PURCHASE_ID =
      "SELECT product_id, purchase_id, price, title, brand " +
      "FROM product " +
      "WHERE purchase_id = :purchaseId";

  private static final String SQL_GET_PRODUCT_LIST_BY_PRODUCT_ID =
      "SELECT product_id, purchase_id, price, title, brand " +
      "FROM product " +
      "WHERE product_id = :productId";

  private static final String SQL_GET_PRODUCT_BY_PRODUCT_TITLE =
      "SELECT product_id, purchase_id, price, title, brand " +
      "FROM product " +
      "WHERE title = :productTitle";

  @Override
  public Product getProductByProductId(int productId) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("productId", productId);
      return jdbcTemplate.queryForObject(SQL_GET_PRODUCT_LIST_BY_PRODUCT_ID, params, (rs, i) ->
          new Product(rs.getInt("product_id"),
              rs.getInt("purchase_id"),
              rs.getDouble("price"),
              rs.getString("title"),
              rs.getString("brand")));
    } catch(EmptyResultDataAccessException ex) {
      return null;
    } catch(DataAccessException ex) {
      throw new Exception("Error while getting product by productId" + productId, ex);
    }
  }

  @Override
  public Product getProductByProductTitle(String productTitle) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("productTitle", productTitle);
      return jdbcTemplate.queryForObject(SQL_GET_PRODUCT_BY_PRODUCT_TITLE, params, (rs, i) ->
          new Product(rs.getInt("product_id"),
              rs.getInt("purchase_id"),
              rs.getDouble("price"),
              rs.getString("title"),
              rs.getString("brand")));
    } catch(EmptyResultDataAccessException ex) {
      return null;
    } catch(DataAccessException ex) {
      throw new Exception("Error while getting product by productTitle" + productTitle, ex);
    }
  }

  @Override
  public List<Product> getProductListByPurchaseId(int purchaseId) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("purchaseId", purchaseId);
      return jdbcTemplate.query(SQL_GET_PRODUCT_LIST_BY_PURCHASE_ID, params, (rs, i) ->
          new Product(rs.getInt("product_id"),
              rs.getInt("purchase_id"),
              rs.getDouble("price"),
              rs.getString("title"),
              rs.getString("brand")));
    } catch(EmptyResultDataAccessException ex) {
      return null;
    } catch(DataAccessException ex) {
      throw new Exception("Error while getting product list.", ex);
    }
  }
}
