package com.studenthackv.repository.impl;

import com.studenthackv.model.Customer;
import com.studenthackv.repository.ApiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ApiRepositoryImpl implements ApiRepository {

  private static final String SQL_INSERT_API_CACHING =
      "INSERT INTO api_caching (product_title, job_id) VALUES (:productTitle, :jobId)";

  private static final String SQL_GET_API_CACHING =
      "SELECT job_id " +
      "FROM api_caching " +
      "WHERE product_title = :productTitle";

  private NamedParameterJdbcTemplate jdbcTemplate;

  @Autowired
  public ApiRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insertApiCaching(String productTitle, String jobId) throws Exception {

    jdbcTemplate.update(SQL_INSERT_API_CACHING,
        new MapSqlParameterSource()
            .addValue("productTitle", productTitle)
            .addValue("jobId", jobId));
  }

  @Override
  public String getApiCaching(String productTitle) throws Exception {
    try {
      MapSqlParameterSource params = new MapSqlParameterSource()
          .addValue("productTitle", productTitle);
      return jdbcTemplate.queryForObject(SQL_GET_API_CACHING, params, String.class);
    } catch (EmptyResultDataAccessException ex) {
      return null;
    } catch (DataAccessException ex) {
      throw new Exception("Error getting api caching with productTitle" + productTitle, ex);
    }
  }
}
