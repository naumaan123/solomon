package com.spider.solomon;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * Main entry point for the application
 */
@SpringBootApplication
public class SolomonApplication {
	private static EmbeddedDatabase db;

	public static void main(String[] args) {
		// Set up a simple HSQL in-memory database for demo purposes
		db = new EmbeddedDatabaseBuilder()
			.setType(HSQL)
			.addScript("schema.sql")
			.addScript("data.sql")
			.build();

		SpringApplication.run(SolomonApplication.class, args);
	}

	@Bean
	public JdbcTemplate jdbcTemplate () {
		return new JdbcTemplate(db);
	}
}
