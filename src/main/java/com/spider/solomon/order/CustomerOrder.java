package com.spider.solomon.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Information for a customer's order
 */
public class CustomerOrder {
	/**
	 * The order's unique ID
	 */
	private int orderId;
	/**
	 * The ID of the customer for the order
	 */
	private int customerId;
	/**
	 * The date and time the order was placed
	 */
	private LocalDateTime orderDate;
	/**
	 * The total monetary amount of the order
	 */
	private BigDecimal totalAmount;

	/**
	 * List of items in the order
	 */
	private List<OrderItem> items;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
