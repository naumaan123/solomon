package com.spider.solomon.reporting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;

/**
 * Endpoints for general reporting
 */
@RestController
@RequestMapping("/reports")
public class ReportController {
	@Resource
	TrendAnalyzer trendAnalyzer;

	/**
	 * Returns the trend of the total sales data
	 */
	@RequestMapping(value = "/trend", method = RequestMethod.GET)
	public String trend () {
		return trendAnalyzer.saleAmountTrend();
	}
}
