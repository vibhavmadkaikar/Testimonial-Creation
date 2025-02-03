package com.testimonial.customers.services;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testimonial.customers.dto.CustomersDTO;
import com.testimonial.customers.entity.Customers;
import com.testimonial.customers.repository.CustomersRepository;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;

	@Override
	public boolean addCustomer(CustomersDTO dto) {
		Customers entityCustomers = new Customers();
		BeanUtils.copyProperties(dto, entityCustomers);

		customersRepository.save(entityCustomers);

		return true;
	}

	@Override
	public CustomersDTO getCustomerDetails(Integer customerId) {
		Customers entity = customersRepository.findById(customerId).get();
		CustomersDTO dto = new CustomersDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<CustomersDTO> allCustomers() {
		List<Customers> list = customersRepository.findAll();
		ArrayList<CustomersDTO> finalList = new ArrayList<>();
		for (Customers entity : list) {
			CustomersDTO dto = new CustomersDTO();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		return finalList;
	}

	@Override
	public boolean updateCustomer(Integer customerId, CustomersDTO dto) throws NoSuchAlgorithmException {
		Optional<Customers> optionalCustomer = customersRepository.findById(customerId);
		if (optionalCustomer.isPresent())
		{
			Customers existingCustomer = optionalCustomer.get();
			
			// BeanUtils require all fields
			// BeanUtils.copyProperties(dto, existingCustomer);
			
			//update working
			if(dto.getCustomerName() != null)
			{
				existingCustomer.setCustomerName(dto.getCustomerName());
			}
			if(dto.getCustomerEmail() != null)
			{
				existingCustomer.setCustomerEmail(dto.getCustomerEmail());
			}
			if (dto.getPassword() != null)
			{
				existingCustomer.setPassword(dto.getPassword());
			}
			if (dto.getDescription() != null)
			{
				existingCustomer.setDescription(dto.getDescription());
			}
			
	        customersRepository.save(existingCustomer);
	        
	        
	        return true;
		}
		else
			return false;
	}

	@Override
	public boolean deleteCustomer(Integer customerId) {
		if (customersRepository.existsById(customerId)) {
			customersRepository.deleteById(customerId);
			return true;
		}
		else
			return false;
	}

}
