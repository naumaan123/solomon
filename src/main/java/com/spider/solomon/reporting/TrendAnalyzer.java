package com.spider.solomon.reporting;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.stereotype.Component;

import com.spider.solomon.order.CustomerOrder;
import com.spider.solomon.order.CustomerOrderDao;

import jakarta.annotation.Resource;

/**
 * Analyzes trends in sales data
 */
@Component
public class TrendAnalyzer {
	@Resource
	CustomerOrderDao customerOrderDao;

	/**
	 * Returns whether the total sales data is trending up or down
	 */
	public String saleAmountTrend () {
		SimpleRegression r = new SimpleRegression();

		LocalDateTime tmp = customerOrderDao.getAllOrders().stream()
			.map(CustomerOrder::getOrderDate)
			.min(LocalDateTime::compareTo)
			.orElse(LocalDateTime.MIN);

		// Add in data for all orders to the SimpleRegression
		customerOrderDao.getAllOrders().forEach(order -> {
			Long day = ChronoUnit.DAYS.between(tmp, order.getOrderDate());
			double totalAmount = order.getTotalAmount().doubleValue();
			r.addData(day, totalAmount);
		});

		// Calculate the slope of the regression line; negative means trending
		// down, positive is trending up
		Double result = r.getSlope();
		if (result < 0) {
			return "down";
		} else if (result == 0) {
			return "level";
		} else {
			return "up";
		}
	}
}
