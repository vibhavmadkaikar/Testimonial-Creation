package com.testimonial.authenticate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testimonial.authenticate.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
