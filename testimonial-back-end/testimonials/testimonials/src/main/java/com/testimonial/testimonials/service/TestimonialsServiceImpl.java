package com.testimonial.testimonials.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testimonial.testimonials.dto.TestimonialsDTO;
import com.testimonial.testimonials.entity.Testimonials;
import com.testimonial.testimonials.repository.TestimonialsRepository;

@Service
public class TestimonialsServiceImpl implements TestimonialsService {

	@Autowired
	TestimonialsRepository testimonialsRespository;

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
		if(dto.getRating() != null)
		{
		existingCustomer.setRating(dto.getRating());
		}
		if (dto.getUserId() != null)
		{
		existingCustomer.setUserId(dto.getUserId());
		}
		if (dto.getCustomerId() != null)
		{
		existingCustomer.setCustomerId(dto.getCustomerId());
		}
		if (dto.getDescription() != null)
		{
		existingCustomer.setDescription(dto.getDescription());
		}
		if (dto.getCustomerAbout() != null)
		{
		existingCustomer.setCustomerAbout(dto.getCustomerAbout());
		}
				if (dto.getCustomerAbout() != null)
		{
		existingCustomer.setCustomerAbout(dto.getCustomerAbout());
		}
		if (dto.getCreatedAt() != null)
		{
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

}
