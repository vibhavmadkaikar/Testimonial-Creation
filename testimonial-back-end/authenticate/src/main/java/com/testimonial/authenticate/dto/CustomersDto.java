package com.testimonial.authenticate.dto;

public class CustomersDto {

	private Integer customerId;
	private String customerName;
	private String customerEmail;
	private String password;
	private String description;

	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomersDto() {
		super();
		this.customerName = "";
		this.customerEmail = "";
		this.password = "";
		this.description = "";
	}

}
