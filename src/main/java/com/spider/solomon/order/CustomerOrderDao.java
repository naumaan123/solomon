package com.spider.solomon.order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import jakarta.annotation.Resource;

@Repository
public class CustomerOrderDao {
	@Resource
	JdbcTemplate jdbcTemplate;
	@Resource
	OrderItemDao orderItemDao;

	/**
	 * Get all orders in the system
	 */
	public List<CustomerOrder> getAllOrders () {
		String sql = "SELECT * FROM customer_orders";
		return jdbcTemplate.query(sql, ORDER_MAPPER);
	}

	/**
	 * Retrieve a single order by order ID
	 */
	public CustomerOrder getOrderById (int orderId) {
		String sql = "SELECT * FROM customer_orders WHERE order_id = ?";
		return jdbcTemplate.queryForObject(sql, ORDER_MAPPER, orderId);
	}

	/**
	 * Retrieve all orders for a single customer
	 */
	public List<CustomerOrder> getOrdersByCustomerId (int customerId) {
		String sql = "SELECT * FROM customer_orders WHERE customer_id = ?";

		List<CustomerOrder> ordrs = jdbcTemplate.query(sql, ORDER_MAPPER, customerId);
		ordrs.forEach(order -> {
			order.setItems(orderItemDao.getOrderItemsByOrderId(order.getOrderId()));
		});

		return ordrs;
	}

	/**
	 * A Spring JDBC RowMapper for building CustomerOrder objects. Note that
	 * this *is* threadsafe, so a single instance can be used for all queries.
	 */
	private static final RowMapper<CustomerOrder> ORDER_MAPPER = (rs, rowNum) -> {
		CustomerOrder order = new CustomerOrder();
		order.setOrderId(rs.getInt("order_id"));
		order.setCustomerId(rs.getInt("customer_id"));
		order.setOrderDate(rs.getTimestamp("order_date").toLocalDateTime());
		order.setTotalAmount(rs.getBigDecimal("total_amount"));
		return order;
	};
}
