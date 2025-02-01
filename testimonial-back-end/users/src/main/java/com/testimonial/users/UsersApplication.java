package com.testimonial.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages = {"com.testimonial.users.controller","com.testimonial.users.service"})
@EntityScan(basePackages = {"com.testimonial.users.entity"})
@EnableJpaRepositories(basePackages = {"com.testimonial.users.repository"})
public class UsersApplication {

	private final JdbcTemplate jdbcTemplate;

    public UsersApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner resetAutoIncrement() {
        return args -> {
            jdbcTemplate.execute("ALTER TABLE users AUTO_INCREMENT = 1000");
        };
    }

}
