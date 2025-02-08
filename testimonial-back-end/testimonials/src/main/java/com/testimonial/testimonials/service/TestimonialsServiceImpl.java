package com.testimonial.testimonials.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.testimonial.testimonials.dto.CustomersDto;
import com.testimonial.testimonials.dto.TestimonialUserDTO;
import com.testimonial.testimonials.dto.TestimonialsDTO;
import com.testimonial.testimonials.dto.UsersDto;
import com.testimonial.testimonials.entity.Testimonials;
import com.testimonial.testimonials.repository.TestimonialsRepository;

@Service
public class TestimonialsServiceImpl implements TestimonialsService {

	@Autowired
	TestimonialsRepository testimonialsRespository;
	
	@Autowired
    private RestTemplate restTemplate;

	@Override
	public boolean addTestimonial(TestimonialsDTO dto) {
		Testimonials entitytestimonial = new Testimonials();
		BeanUtils.copyProperties(dto, entitytestimonial);

		testimonialsRespository.save(entitytestimonial);

		return true;
	}

	@Override
	public TestimonialsDTO getTestimonialDetails(Integer testimonialId) {
		Testimonials entity = testimonialsRespository.findById(testimonialId).get();
		TestimonialsDTO dto = new TestimonialsDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<TestimonialsDTO> allTestimonials() {
		List<Testimonials> list = testimonialsRespository.findAll();
		ArrayList<TestimonialsDTO> finalList = new ArrayList<>();
		for (Testimonials entity : list) {
			TestimonialsDTO dto = new TestimonialsDTO();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		return finalList;
	}

	@Override
	public boolean updateTestimonials(Integer testimonialId, TestimonialsDTO dto) {
		Optional<Testimonials> optionalCustomer = testimonialsRespository.findById(testimonialId);
		if (optionalCustomer.isPresent()) {
			Testimonials existingCustomer = optionalCustomer.get();

//			// BeanUtils require all fields
//			BeanUtils.copyProperties(dto, existingCustomer);

			// update not working
			if (dto.getRating() != null) {
				existingCustomer.setRating(dto.getRating());
			}
			if (dto.getUserId() != null) {
				existingCustomer.setUserId(dto.getUserId());
			}
			if (dto.getCustomerId() != null) {
				existingCustomer.setCustomerId(dto.getCustomerId());
			}
			if (dto.getDescription() != null) {
				existingCustomer.setDescription(dto.getDescription());
			}
			if (dto.getCustomerAbout() != null) {
				existingCustomer.setCustomerAbout(dto.getCustomerAbout());
			}
			if (dto.getCustomerAbout() != null) {
				existingCustomer.setCustomerAbout(dto.getCustomerAbout());
			}
			if (dto.getCreatedAt() != null) {
				existingCustomer.setCreatedAt(dto.getCreatedAt());
			}

			testimonialsRespository.save(existingCustomer);

			return true;
		} else
			return false;
	}

	@Override
	public boolean deletetestimonials(Integer testimonialId) {
		if (testimonialsRespository.existsById(testimonialId)) {
			testimonialsRespository.deleteById(testimonialId);
			return true;
		} else
			return false;
	}

//	@Override
//	public List<TestimonialsDTO> getTestimonialsByUser(String username) {
//
//		List<Testimonials> entityList = testimonialsRespository.getAllTestimonialsByUser(username);
//
//		List<TestimonialsDTO> finalList = new ArrayList<>();
//
//		for (Testimonials entity : entityList) {
//
//			TestimonialsDTO dto = new TestimonialsDTO();
//
//			BeanUtils.copyProperties(entity, dto);
//
//			finalList.add(dto);
//		}
//		return finalList;
//	}
	

	@Override
	public List<TestimonialUserDTO> getTestimonialsByUser(String username) {
	    List<Object[]> results = testimonialsRespository.getAllTestimonialsByUser(username);
	    List<TestimonialUserDTO> testimonialsList = new ArrayList<>();

	    for (Object[] row : results) {
	        TestimonialUserDTO dto = new TestimonialUserDTO();
	        
	        // Correct Mapping:
	        dto.setTestimonialId((Integer) row[0]);  // ✅ Testimonial ID
	        dto.setUserId((Integer) row[1]);         // ✅ User ID
	        dto.setCustomerId((Integer) row[2]);     // ✅ Customer ID
	        dto.setCustomerName((String) row[3]);    // ✅ Customer Name (String)
	        dto.setCustomerAbout((String) row[4]);   // ✅ Customer About (String)
	        dto.setRating((Integer) row[5]);         // ✅ Rating (Integer)
	        dto.setCreatedAt(((Timestamp) row[6]).toLocalDateTime());  // ✅ Convert Timestamp to LocalDateTime
	        dto.setDescription((String) row[7]);     // ✅ Description (String)

	        CustomersDto customerDTO = null;
	        
	        // Fetch user details from authenticate-service
	        try {
	            if (dto.getUserId() != null) {
	                String userUri = "http://localhost:4000/auth/user/getUserById/" + dto.getUserId();
	                UsersDto userDTO = restTemplate.getForObject(userUri, UsersDto.class);
	                dto.setUser(userDTO);
	            }
	        } catch (Exception e) {
	            System.err.println("Error fetching user details: " + e.getMessage());
	        }

	        // Fetch customer details from authenticate-service
	        try {
	            if (dto.getCustomerId() != null) {
	            	String userUri = "http://localhost:4000/auth/user/getUserById/" + dto.getUserId();
	            	String customerUri = "http://localhost:4000/auth/customer/getCustomerById/" + dto.getCustomerId();
	                dto.setCustomer(customerDTO);
	            }
	        } catch (Exception e) {
	            System.err.println("Error fetching customer details: " + e.getMessage());
	        }

	        testimonialsList.add(dto);
	    }
	    return testimonialsList;
	}



}
