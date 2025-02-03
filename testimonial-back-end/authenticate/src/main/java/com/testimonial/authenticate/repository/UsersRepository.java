package com.testimonial.authenticate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testimonial.authenticate.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
