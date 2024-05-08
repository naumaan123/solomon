package com.spider.solomon.order;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/**
 * REST endpoints for customer orders
 */
@RestController
@RequestMapping("/orders")
public class CustomerOrderController {
	@Resource
	CustomerOrderDao customerOrderDao;

	/**
	 * Lists all orders in the system
	 */
	@GetMapping
	public List<CustomerOrder> getAll () {
		return customerOrderDao.getAllOrders();
	}
}
