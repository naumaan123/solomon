package com.spider.solomon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple REST endpoint to test that the server is running
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String index() {
		return "hello";
	}
}
