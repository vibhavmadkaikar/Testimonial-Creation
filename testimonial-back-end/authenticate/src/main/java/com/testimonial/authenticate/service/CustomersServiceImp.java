package com.testimonial.authenticate.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testimonial.authenticate.dto.CustomersDto;
import com.testimonial.authenticate.entity.Customers;
import com.testimonial.authenticate.repository.CustomersRepository;

@Service
public class CustomersServiceImp implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;

	@Override
	public boolean addCustomer(CustomersDto dto) {
		Customers entityCustomers = new Customers();
		BeanUtils.copyProperties(dto, entityCustomers);

		customersRepository.save(entityCustomers);

		return true;
	}

	@Override
	public CustomersDto getCustomerDetails(Integer customerId) {
		Customers entity = customersRepository.findById(customerId).get();
		CustomersDto dto = new CustomersDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<CustomersDto> allCustomers() {
		List<Customers> list = customersRepository.findAll();
		ArrayList<CustomersDto> finalList = new ArrayList<>();
		for (Customers entity : list) {
			CustomersDto dto = new CustomersDto();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		return finalList;
	}

	@Override
	public boolean updateCustomer(Integer customerId, CustomersDto dto) throws NoSuchAlgorithmException {
		Optional<Customers> optionalCustomer = customersRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {
			Customers existingCustomer = optionalCustomer.get();

			if (dto.getCustomerName() != null) {
				existingCustomer.setCustomerName(dto.getCustomerName());
			}
			if (dto.getCustomerEmail() != null) {
				existingCustomer.setCustomerEmail(dto.getCustomerEmail());
			}
			if (dto.getPassword() != null) {
				existingCustomer.setPassword(dto.getPassword());
			}
			if (dto.getDescription() != null) {
				existingCustomer.setDescription(dto.getDescription());
			}

			customersRepository.save(existingCustomer);

			return true;
		} else
			return false;
	}

	@Override
	public boolean deleteCustomer(Integer customerId) {
		if (customersRepository.existsById(customerId)) {
			customersRepository.deleteById(customerId);
			return true;
		} else {
			return false;
		}
	}

}
