package com.spider.solomon.customer;

/**
 * Basic customer information
 */
public class Customer {
	/**
	 * The customer's unique ID
	 */
	private Integer id;
	/**
	 * The customer's full name
	 */
	private String name;
	/**
	 * The customer's email address
	 */
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
