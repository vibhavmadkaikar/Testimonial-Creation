package com.testimonial.testimonials.dto;

import java.time.LocalDateTime;

public class TestimonialsDTO {

	private Integer testimonialId;

	private String username; // Field for username
	private String customername; // Field for customername

	private Integer rating;

	private Integer customerId;

	private Integer userId;

//	private byte[] picture;

	private String description;

	private String customerAbout;

	private LocalDateTime createdAt;

	private Boolean isVisible;

	public TestimonialsDTO() {
//		this.testimonialId = 0;
		this.setUsername(username);
		this.setCustomername(customername);
		this.description = "";
//		this.createdAt = null;
		this.isVisible = true;
	}

	public TestimonialsDTO(Integer testimonialId, String username, String customername, String description,
			Integer rating, LocalDateTime createdAt, Boolean isVisible) {
		// TODO Auto-generated constructor stub
	}

	public Integer getTestimonialId() {
		return testimonialId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getCustomerId() {
		return customerId;
	}

//	public byte[] getPicture() {
//		return picture;
//	}
//
//	public void setPicture(byte[] picture) {
//		this.picture = picture;
//	}

//	public void setTestimonialId(Integer testimonialId) {
//		this.testimonialId = testimonialId;
//	}
//
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

}
