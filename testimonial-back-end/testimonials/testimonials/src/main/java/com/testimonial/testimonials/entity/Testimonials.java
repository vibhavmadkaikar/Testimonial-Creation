package com.testimonial.testimonials.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="testimonials")
public class Testimonials {

//	testimonialid int auto_increment,
//    rating int default(0),
//    customername varchar(255) not null,
//    picture blob,
//    description varchar(255) not null,
//    customerabout varchar(255) not null,
//    createdat datetime not null,
//    isvisible boolean,
	
	@Id
	@Column(name="testimonialid")
	private Integer testimonialId;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="customername")
	private String customerName;
	
	@Column(name="picture")
	private byte[] picture;
	
	@Column(name="description")
	private String description;
	
	@Column(name="customerabout")
	private String customerAbout;
	
	@Column(name = "createdat")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDat;
	
	@Column(name="isvisible")
	private Boolean isVisible;

	
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
