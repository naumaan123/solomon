package com.spider.solomon.customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component
public class CustomerDao {
	@Resource
	JdbcTemplate jdbcTemplate;

	/**
	 * Get all customers in the system
	 */
	public List<Customer> getAllCustomers() {
		String sql = "SELECT * FROM customers";
		return jdbcTemplate.query(sql, CUSTOMER_MAPPER);
	}

	/**
	 * Retrieve a single customer by customer ID
	 */
	public Customer getCustomer(Integer id) {
		String sql = "SELECT * FROM customers where customer_id = ?";
		return jdbcTemplate.queryForObject(sql, CUSTOMER_MAPPER, id);
	}

	/**
	 * A Spring JDBC RowMapper for building Customer objects. Note that this
	 * *is* threadsafe, so a single instance can be used for all queries.
	 */
	private static final RowMapper<Customer> CUSTOMER_MAPPER = (ResultSet rs, int rowNum) -> {
		Customer customer = new Customer();
		customer.setId(rs.getInt("customer_id"));
		customer.setName(rs.getString("name"));
		customer.setEmail(rs.getString("email"));
		return customer;
	};
}
