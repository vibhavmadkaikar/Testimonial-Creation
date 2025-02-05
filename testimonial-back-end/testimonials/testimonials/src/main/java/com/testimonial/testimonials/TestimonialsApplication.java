package com.testimonial.testimonials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.testimonial.testimonials.controllers",
"com.testimonial.testimonials.service"})
@EntityScan(basePackages = {"com.testimonial.testimonials.entity"})
@EnableJpaRepositories(basePackages = {"com.testimonial.testimonials.repository"})
public class TestimonialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestimonialsApplication.class, args);
	}

}
