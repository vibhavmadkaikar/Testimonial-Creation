package com.testimonial.testimonials.controllers;


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

import com.testimonial.testimonials.dto.TestimonialsDTO;
import com.testimonial.testimonials.service.TestimonialsService;

@RestController
@RequestMapping("/testimonials")
public class TestimonialsControllers {

	@Autowired
	TestimonialsService testimonialsService;

	@PostMapping("/addtestimonial")
	public boolean addCustomers(@RequestBody TestimonialsDTO dto)
	{
	return  testimonialsService.addTestimonial(dto);
	}

	@GetMapping("/allTestimonials")
	public List<TestimonialsDTO> allCustomers()
	{
	return testimonialsService.allTestimonials();
	}

	@GetMapping("/getTestimonialDetails/{id}")
	public TestimonialsDTO getCustomerDetails(@PathVariable("id") Integer testimonialId)
	{
	return testimonialsService.getTestimonialDetails(testimonialId);
	}

	@PutMapping("/UpdateTestimonialDetails/{id}")
	public boolean updateCustomerDetails(@PathVariable("id") Integer testimonialId, @RequestBody TestimonialsDTO dto) throws NoSuchAlgorithmException
	{
	return testimonialsService.updateTestimonials(testimonialId, dto);
	}

	@DeleteMapping("/DeleteTestimonialDetails/{id}")
	public boolean deleteUser(@PathVariable("id") Integer testimonialId)
	{
	return testimonialsService.deletetestimonials(testimonialId);
	}
}
