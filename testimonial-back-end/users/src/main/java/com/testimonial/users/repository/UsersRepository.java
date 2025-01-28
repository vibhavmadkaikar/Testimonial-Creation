package com.testimonial.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testimonial.users.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

}
