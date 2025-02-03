package com.testimonial.testimonials.dto;

import java.util.Date;

public class TestimonialsDTO {

	private Integer testimonialId;

	private Integer rating;

	private String customerName;

	private byte[] picture;

	private String description;

	private String customerAbout;

	private Date createDat;

	private Boolean isVisible;

	public Integer getTestimonialId() {
		return testimonialId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
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

	public Date getCreateDat() {
		return createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	public Boolean getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}

}
