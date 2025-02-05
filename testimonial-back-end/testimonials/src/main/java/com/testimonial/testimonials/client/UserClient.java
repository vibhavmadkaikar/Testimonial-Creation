package com.testimonial.testimonials.client;

import com.testimonial.testimonials.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Calls the Authentication Microservice for User Data
@FeignClient(name = "user-service", qualifiers = "user-service")
public interface UserClient {
    @GetMapping("/users/{userId}")
    UserDTO getUserById(@PathVariable("userId") Integer userId);
}
