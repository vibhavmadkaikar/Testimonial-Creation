package com.testimonial.authenticate.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.testimonial.authenticate.dto.CustomersDto;

public interface CustomersService {

	public boolean addCustomer(CustomersDto dto);

	public CustomersDto getCustomerDetails(Integer customerId);

	public List<CustomersDto> allCustomers();

	public boolean updateCustomer(Integer customerId, CustomersDto dto) throws NoSuchAlgorithmException;

	public boolean deleteCustomer(Integer customerId);
}
