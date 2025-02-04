package com.testimonial.testimonials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages = {"com.testimonial.testimonials.controllers",
"com.testimonial.testimonials.service"})
@EnableFeignClients(basePackages = "com.example.feignclients")
@EntityScan(basePackages = {"com.testimonial.testimonials.entity"})
@EnableJpaRepositories(basePackages = {"com.testimonial.testimonials.repository"})
//@ComponentScan(basePackages = {"com.testimonial.testimonials.client", "com.testimonial.testimonials.service"})
public class TestimonialsApplication {
	
	private final JdbcTemplate jdbcTemplate;

    public TestimonialsApplication (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

	public static void main(String[] args) {
		SpringApplication.run(TestimonialsApplication.class, args);
	}

	@Bean
    public CommandLineRunner resetAutoIncrement() {
        return args -> {
            jdbcTemplate.execute("ALTER TABLE testimonials AUTO_INCREMENT = 3000");
        };
    }
}
