package com.testimonial.testimonials.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.testimonial.testimonials.client.CustomerClient;
import com.testimonial.testimonials.client.UserClient;
import com.testimonial.testimonials.dto.CustomerDTO;
import com.testimonial.testimonials.dto.TestimonialsDTO;
import com.testimonial.testimonials.dto.UserDTO;
import com.testimonial.testimonials.entity.Testimonials;
import com.testimonial.testimonials.repository.TestimonialsRepository;

import jakarta.annotation.Nullable;

@Service
public class TestimonialsServiceImpl implements TestimonialsService {

	@Autowired
	TestimonialsRepository testimonialsRepository;
	
	  private final UserClient userClient;
	    private final CustomerClient customerClient;

	    @Autowired
	    public TestimonialsServiceImpl(@Nullable @Qualifier("user-service") UserClient userClient,
	                                   @Nullable @Qualifier("client-service") CustomerClient customerClient) {
	        this.userClient = userClient;
	        this.customerClient = customerClient;
	    }
//	@Autowired
//	private UserClient userClient; // Fetch Users via Feign
//
//	@Autowired
//	private CustomerClient customerClient; // Fetch Customers via Feign

	@Override
	public boolean addTestimonial(TestimonialsDTO dto) {
		Testimonials entitytestimonial = new Testimonials();
		BeanUtils.copyProperties(dto, entitytestimonial);

		testimonialsRepository.save(entitytestimonial);

		return true;
	}

	@Override
	public TestimonialsDTO getTestimonialDetails(Integer testimonialId) {
		Testimonials entity = testimonialsRepository.findById(testimonialId).get();
		TestimonialsDTO dto = new TestimonialsDTO();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public List<TestimonialsDTO> allTestimonials() {
		List<Testimonials> list = testimonialsRepository.findAll();
		ArrayList<TestimonialsDTO> finalList = new ArrayList<>();
		for (Testimonials entity : list) {
			TestimonialsDTO dto = new TestimonialsDTO();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		return finalList;
	}

//	@Override
//	public boolean updateTestimonials(Integer testimonialId, TestimonialsDTO dto) {
//		Optional<Testimonials> optionalCustomer = testimonialsRepository.findById(testimonialId);
//		if (optionalCustomer.isPresent()) {
//			Testimonials existingCustomer = optionalCustomer.get();
//
//			BeanUtils.copyProperties(dto, existingCustomer);
//
//			testimonialsRepository.save(existingCustomer);
//
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	@Override
	public boolean updateTestimonials(Integer testimonialId, TestimonialsDTO dto) {
	    Optional<Testimonials> optionalCustomer = testimonialsRepository.findById(testimonialId);
	    if (optionalCustomer.isPresent()) {
	        Testimonials existingCustomer = optionalCustomer.get();
	        // Map DTO to entity without altering the identifier
	        BeanUtils.copyProperties(dto, existingCustomer, "testimonialId");
	        testimonialsRepository.save(existingCustomer);
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public boolean deletetestimonials(Integer testimonialId) {
		if (testimonialsRepository.existsById(testimonialId)) {
			testimonialsRepository.deleteById(testimonialId);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TestimonialsDTO getTestimonialById(Integer testimonialId) {
		// Fetch testimonial from DB
		Testimonials testimonial = testimonialsRepository.findById(testimonialId)
				.orElseThrow(() -> new RuntimeException("Testimonial not found"));

		// Fetch user details from Auth Service
		UserDTO user = userClient.getUserById(testimonial.getUserId());

		// Fetch customer details from Auth Service
		CustomerDTO customer = customerClient.getCustomerById(testimonial.getCustomerId());

		// Build response DTO
		return new TestimonialsDTO(testimonial.getTestimonialId(), user.getUsername(), customer.getCustomername(),
				testimonial.getDescription(), testimonial.getRating(), testimonial.getCreatedAt(),
				testimonial.getIsVisible());
	}

}
