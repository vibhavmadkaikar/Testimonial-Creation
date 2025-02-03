package com.testimonial.authenticate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages = {"com.testimonial.authenticate.controller","com.testimonial.authenticate.service"})
@EntityScan(basePackages = {"com.testimonial.authenticate.entity"})
@EnableJpaRepositories(basePackages = {"com.testimonial.authenticate.repository"})
public class AuthenticateApplication {
	
	private final JdbcTemplate jdbcTemplate;

    public AuthenticateApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

	public static void main(String[] args) {
		SpringApplication.run(AuthenticateApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner resetAutoIncrement() {
        return args -> {
            jdbcTemplate.execute("ALTER TABLE users AUTO_INCREMENT = 1000");
            jdbcTemplate.execute("ALTER TABLE customers AUTO_INCREMENT = 2000");
        };
    }

}
