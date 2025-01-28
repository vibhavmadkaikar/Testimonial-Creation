package com.testimonial.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.testimonial.users.controller","com.testimonial.users.service"})
@EntityScan(basePackages = {"com.testimonial.users.entity"})
@EnableJpaRepositories(basePackages = {"com.testimonial.users.repository"})
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
