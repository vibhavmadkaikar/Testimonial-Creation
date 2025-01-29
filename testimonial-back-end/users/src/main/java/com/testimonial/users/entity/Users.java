package com.testimonial.users.entity;

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
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
public class Users {

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "domain")
	private String domain;

	public Users() {
		this.username = "";
		this.password = "";
		this.email = "";
		this.domain = "";
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
