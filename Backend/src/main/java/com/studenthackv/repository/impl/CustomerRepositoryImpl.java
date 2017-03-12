package com.studenthackv.repository.impl;

import com.studenthackv.model.Customer;
import com.studenthackv.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public CustomerRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  private static final String SQL_GET_CUSTOMER_LIST =
      "SELECT email_address, name, address, phone_number" +
      " FROM customer";

  private static final String SQL_GET_CUSTOMER =
      "SELECT email_address, name, address, phone_number" +
      " FROM customer" +
      " WHERE email_address = :emailAddress";


  @Override
  public Customer getCustomerByEmailAddress(String emailAddress) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("emailAddress", emailAddress);
      return jdbcTemplate.queryForObject(SQL_GET_CUSTOMER, params, (rs, i) ->
          new Customer(rs.getString("email_address"),
              rs.getString("name"),
              rs.getString("address"),
              rs.getString("phone_number")));
    } catch(EmptyResultDataAccessException ex) {
      return null;
    } catch(DataAccessException ex) {
      throw new Exception("Error while getting customer with emailAddress" + emailAddress, ex);
    }
  }

  @Override
  public List<Customer> getCustomerList() throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource();
      return jdbcTemplate.query(SQL_GET_CUSTOMER_LIST, params, (rs, i) ->
          new Customer(rs.getString("email_address"),
              rs.getString("name"),
              rs.getString("address"),
              rs.getString("phone_number")));
    } catch(EmptyResultDataAccessException ex) {
      return null;
    } catch(DataAccessException ex) {
      throw new Exception("Error while getting customer list", ex);
    }
  }
}
