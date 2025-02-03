package com.testimonial.customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages = { "com.testimonial.customers.controllers",
		"com.testimonial.customers.services" })
@EntityScan(basePackages = { "com.testimonial.customers.entity" })
@EnableJpaRepositories(basePackages = { "com.testimonial.customers.repository" })
public class CustomersApplication {

	private final JdbcTemplate jdbcTemplate;

	public CustomersApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

	@Bean
    public CommandLineRunner resetAutoIncrement() {
        return args -> {
            jdbcTemplate.execute("ALTER TABLE users AUTO_INCREMENT = 1000");
        };
	}
}
