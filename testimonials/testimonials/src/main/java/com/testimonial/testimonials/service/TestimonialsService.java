package com.testimonial.testimonials.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.testimonial.testimonials.dto.TestimonialsDTO;

public interface TestimonialsService {

	public boolean addTestimonial(TestimonialsDTO dto);

	public TestimonialsDTO getTestimonialDetails(Integer testimonialId);

	public List<TestimonialsDTO> allTestimonials();

	public boolean updateTestimonials(Integer testimonialId, TestimonialsDTO dto)  throws NoSuchAlgorithmException;

	public boolean deletetestimonials(Integer testimonialId);

}
