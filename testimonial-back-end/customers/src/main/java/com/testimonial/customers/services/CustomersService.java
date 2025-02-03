package com.testimonial.customers.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.testimonial.customers.dto.CustomersDTO;

public interface CustomersService {

	public boolean addCustomer(CustomersDTO dto);

	public CustomersDTO getCustomerDetails(Integer customerId);

	public List<CustomersDTO> allCustomers();

	public boolean updateCustomer(Integer customerId, CustomersDTO dto)  throws NoSuchAlgorithmException;

	public boolean deleteCustomer(Integer customerId);

	// public Testimonial getTestimonialByEmail(String customerEmail);
	// public Testimonial getTestimonialById(Integer testimonialId);
	// public Testimonial updateTestimonialById(Integer testimonialId);
	// public Testimonial deleteTestimonialById(Integer testimonialId);

}
