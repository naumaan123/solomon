package com.spider.solomon.order;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;

@Repository
public class OrderItemDao {
	@Resource
	JdbcTemplate jdbcTemplate;

	public List<OrderItem> getOrderItemsByOrderId (int orderId) {
		return jdbcTemplate.query("SELECT * FROM order_items WHERE order_id = ?", M, orderId);
	}

	/**
	 * A Spring JDBC RowMapper for building CustomerOrder objects. Note that this
	 * *is* threadsafe, so a single instance can be used for all queries.
	 */
	private static final RowMapper<OrderItem> M = (rs, rowNum) -> {
		OrderItem tmp = new OrderItem();
		tmp.setId(rs.getInt("order_item_id"));
		tmp.setName(rs.getString("name"));
		tmp.setQuantity(rs.getInt("quantity"));
		return tmp;
	};
}
