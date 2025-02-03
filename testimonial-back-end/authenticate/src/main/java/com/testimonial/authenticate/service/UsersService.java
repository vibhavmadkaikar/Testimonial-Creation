package com.testimonial.authenticate.service;

import java.util.List;

import com.testimonial.authenticate.dto.UsersDto;

public interface UsersService {
	public boolean addUser(UsersDto dto);

	public UsersDto getUsersById(Integer userId);

	public List<UsersDto> getAllUsers();

	public boolean deleteUsers(Integer userId);

	public boolean updateUsers(Integer userId, UsersDto dto);
}
