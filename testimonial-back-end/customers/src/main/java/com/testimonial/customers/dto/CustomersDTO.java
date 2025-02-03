package com.testimonial.customers.dto;

public class CustomersDTO {

	Integer customerId;
	String customerName;
	String customerEmail;
	String password;
	String description;

	public int getCustomerId() {
		return customerId;
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

	public CustomersDTO() {
		super();
		this.customerName = "";
		this.customerEmail = "";
		this.password = "";
		this.description = "";
	}

}
