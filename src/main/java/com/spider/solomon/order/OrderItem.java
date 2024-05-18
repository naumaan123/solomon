package com.spider.solomon.order;

/**
 * Information for an item in an order
 */
public class OrderItem {
	/**
	 * The item's unique ID
	 */
	private Integer id;
	/*
	 * The name of the item (eg. "Stapler")
	 */
	private String name;
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
