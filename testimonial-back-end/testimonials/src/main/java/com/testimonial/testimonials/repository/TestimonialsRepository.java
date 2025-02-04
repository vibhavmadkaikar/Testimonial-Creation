package com.testimonial.testimonials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testimonial.testimonials.entity.Testimonials;

@Repository
public interface TestimonialsRepository extends JpaRepository<Testimonials, Integer> {

}
