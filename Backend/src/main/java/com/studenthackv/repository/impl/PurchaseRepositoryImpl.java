package com.studenthackv.repository.impl;

import com.studenthackv.model.Purchase;
import com.studenthackv.repository.PurchaseRepository;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {

  private static final String SQL_GET_PURCHASE_BY_PURCHASE_ID =
      "SELECT purchase_id, email_address, purchase_date, total_value, retailer " +
      "FROM purchase " +
      "WHERE purchase_id = :purchaseId";
  private static final String SQL_GET_PURCHASE_LIST_BY_EMAIL_ADDRESS =
      "SELECT purchase_id, email_address, purchase_date, total_value, retailer " +
      "FROM purchase " +
      "WHERE email_address = :emailAddress";
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public PurchaseRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Purchase getPurchaseByPurchaseId(int purchaseId) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("purchaseId", purchaseId);
      return jdbcTemplate.queryForObject(SQL_GET_PURCHASE_BY_PURCHASE_ID, params, (rs, i) ->
          new Purchase(rs.getInt("purchase_id"),
              rs.getString("email_address"),
              rs.getTimestamp("purchase_date") == null ? null :
                  new DateTime(rs.getTimestamp("purchase_date")),
              rs.getDouble("total_value"),
              rs.getString("retailer")));
    } catch (EmptyResultDataAccessException ex) {
      return null;
    } catch (DataAccessException ex) {
      throw new Exception("Error while getting purchase by purchaseId" + purchaseId, ex);
    }
  }

  @Override
  public List<Purchase> getPurchaseListByEmailAddress(String emailAddress) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("emailAddress", emailAddress);
      return jdbcTemplate.query(SQL_GET_PURCHASE_LIST_BY_EMAIL_ADDRESS, params, (rs, i) ->
          new Purchase(rs.getInt("purchase_id"),
              rs.getString("email_address"),
              rs.getTimestamp("purchase_date") == null ? null :
                  new DateTime(rs.getTimestamp("purchase_date")),
              rs.getDouble("total_value"),
              rs.getString("retailer")));
    } catch (EmptyResultDataAccessException ex) {
      return null;
    } catch (DataAccessException ex) {
      throw new Exception("Error while getting purchase by emailAddress" + emailAddress, ex);
    }
  }
}
