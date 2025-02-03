package com.testimonial.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testimonial.customers.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
