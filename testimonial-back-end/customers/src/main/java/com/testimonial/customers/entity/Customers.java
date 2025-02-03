package com.testimonial.customers.entity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
@DynamicInsert
@DynamicUpdate
public class Customers {

	@Id
	@Column(name = "customerid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name = "customername")
	private String customerName;

	@Column(name = "customeremail")
	private String customerEmail;

	@Column(name = "password")
	private String password;

	@Column(name = "description")
	private String description;

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

	public void setPassword(String password) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("MD5");

		byte[] messageDigest = md.digest(password.getBytes());

		BigInteger bigInt = new BigInteger(1, messageDigest);

		this.password = bigInt.toString(16);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customers() {
		super();
		this.customerName = "";
		this.customerEmail = "";
		this.password = "";
		this.description = "";
	}

}
