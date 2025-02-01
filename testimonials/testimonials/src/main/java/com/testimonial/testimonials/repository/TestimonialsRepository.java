package com.testimonial.testimonials.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testimonial.testimonials.entity.Testimonials;

public interface TestimonialsRepository extends JpaRepository<Testimonials, Integer> {

}
