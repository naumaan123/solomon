package com.spider.solomon.customer;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spider.solomon.order.CustomerOrder;
import com.spider.solomon.order.CustomerOrderDao;

import jakarta.annotation.Resource;

/**
 * REST endpoints for customer information
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Resource
	CustomerDao customerDao;
	@Resource
	CustomerOrderDao customerOrderDao;

	/**
	 * Lists all customers in the system
	 */
	@GetMapping
	public List<Customer> getAll () {
		return customerDao.getAllCustomers();
	}

	/**
	 * Retrieves a single customer by ID
	 */
	@GetMapping("/{id}")
	public Customer get (@PathVariable Integer id) {
		return customerDao.getCustomer(id);
	}

	/**
	 * Retrieves all orders for a single customer
	 */
	@GetMapping("/{customerId}/orders")
	public List<CustomerOrder> getCustomerOrders (@PathVariable Integer customerId) {
		return customerOrderDao.getOrdersByCustomerId(customerId);
	}
}
