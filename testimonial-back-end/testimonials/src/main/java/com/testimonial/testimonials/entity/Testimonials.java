package com.testimonial.testimonials.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "testimonials")
@DynamicInsert
@DynamicUpdate
public class Testimonials {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "testimonialid")
    private Integer testimonialId;

    @Column(name = "rating")
    private Integer rating = 0;

//    // Many-to-One relationship with User
//    @ManyToOne
//    @JoinColumn(name = "userid", nullable = false)
//    private User user;
//
//    // Many-to-One relationship with Customer
//    @ManyToOne
//    @JoinColumn(name = "customerid", nullable = false)
//    private Customer customer;
    
    // Store only ID, no FK constraint
    @Column(name = "userid")
    private Integer userId;

    // Store only ID, no FK constraint
    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "customerabout")
    private String customerAbout;

    @Column(name = "description")
    private String description;

    @Column(name = "createdat")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "isvisible")
    private Boolean isVisible = true;

	public Testimonials() {
		super();
	}

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

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

//	public byte[] getPicture() {
//		return picture;
//	}
//
//	public void setPicture(byte[] picture) {
//		this.picture = picture;
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

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}

}
