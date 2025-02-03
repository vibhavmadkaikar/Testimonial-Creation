package com.testimonial.authenticate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testimonial.authenticate.dto.UsersDto;
import com.testimonial.authenticate.service.UsersService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173/")
public class UsersController {

	@Autowired
	UsersService service;

	@GetMapping("/getUserById/{id}")
	public UsersDto getUserById(@PathVariable("id") Integer userId) {
		return service.getUsersById(userId);
	}

	@GetMapping("/getAllUsers")
	public List<UsersDto> getAllUsers() {
		return service.getAllUsers();
	}

	@PostMapping("/addUser")
	public boolean addUser(@RequestBody UsersDto dto) {
		return service.addUser(dto);
	}

	@DeleteMapping("/deleteUse/{id}")
	public boolean deleteUser(@PathVariable("id") Integer userId) {
		return service.deleteUsers(userId);
	}

	@PutMapping("/updateUser/{id}")
	public boolean updateUser(@PathVariable("id") Integer userId, @RequestBody UsersDto dto) {
		return service.updateUsers(userId, dto);
	}
}
