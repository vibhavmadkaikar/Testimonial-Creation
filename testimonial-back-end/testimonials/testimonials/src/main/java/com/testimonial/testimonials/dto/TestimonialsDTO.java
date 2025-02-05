package com.testimonial.testimonials.dto;

import java.time.LocalDate;
import java.util.Date;

public class TestimonialsDTO {

	private Integer testimonialId;

	private Integer rating;

	private Integer userId;

	private Integer customerId;

	private String description;

	private String customerAbout;

	private LocalDate createDat;

	private Boolean isVisible;

	public Integer getTestimonialId() {
		return testimonialId;
	}

	public void setTestimonialId(Integer testimonialId) {
		this.testimonialId = testimonialId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomerAbout() {
		return customerAbout;
	}

	public void setCustomerAbout(String customerAbout) {
		this.customerAbout = customerAbout;
	}

	public LocalDate getCreateDat() {
		return createDat;
	}

	public void setCreateDat(LocalDate createDat) {
		this.createDat = createDat;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

}
