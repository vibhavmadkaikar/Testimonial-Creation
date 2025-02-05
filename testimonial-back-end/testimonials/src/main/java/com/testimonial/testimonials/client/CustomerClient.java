package com.testimonial.testimonials.client;

import com.testimonial.testimonials.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Calls the Authentication Microservice for Customer Data
@FeignClient(name = "customer-service", qualifiers = "customer-service" )
public interface CustomerClient {
    @GetMapping("/customers/{customerId}")
    CustomerDTO getCustomerById(@PathVariable("customerId") Integer customerId);
}
