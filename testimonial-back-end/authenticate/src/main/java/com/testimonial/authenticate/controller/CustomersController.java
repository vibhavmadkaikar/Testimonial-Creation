package com.testimonial.authenticate.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testimonial.authenticate.dto.CustomersDto;
import com.testimonial.authenticate.service.CustomersService;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	CustomersService customersService;

	@PostMapping("/addCustomer")
	public boolean addCustomers(@RequestBody CustomersDto dto) {
		return customersService.addCustomer(dto);
	}

	@GetMapping("/allCustomers")
	public List<CustomersDto> allCustomers() {
		return customersService.allCustomers();
	}

	@GetMapping("/getCustomerDetails/{id}")
	public CustomersDto getCustomerDetails(@PathVariable("id") Integer customerId) {
		return customersService.getCustomerDetails(customerId);
	}

	@PutMapping("/updateCustomerDetails/{id}")
	public boolean updateCustomerDetails(@PathVariable("id") Integer customerId, @RequestBody CustomersDto dto)
			throws NoSuchAlgorithmException {
		return customersService.updateCustomer(customerId, dto);
	}

	@DeleteMapping("/deleteCustomerDetails/{id}")
	public boolean deleteUser(@PathVariable("id") Integer customerId) {
		return customersService.deleteCustomer(customerId);
	}

}
