package com.testimonial.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testimonial.users.dto.UsersDto;
import com.testimonial.users.entity.Users;
import com.testimonial.users.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService {

	@Autowired
	UsersRepository repository;

	@Override
	public boolean addUser(UsersDto dto) {
		Users entityUsers = new Users();
		BeanUtils.copyProperties(dto, entityUsers);

		repository.save(entityUsers);

		return true;
	}

	@Override
	public UsersDto getUsersById(Integer userId) {
		Optional<Users> optionalUsers = repository.findById(userId);
		if (optionalUsers.isPresent()) {
			Users entityUsers = optionalUsers.get();
			UsersDto dto = new UsersDto();
			BeanUtils.copyProperties(entityUsers, dto);
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public List<UsersDto> getAllUsers() {
		List<Users> list = repository.findAll();
		List<UsersDto> finalList = new ArrayList<>();
		for (Users entity : list) {
			UsersDto dto = new UsersDto();
			BeanUtils.copyProperties(entity, dto);
			finalList.add(dto);
		}
		return finalList;
	}

	@Override
	public boolean deleteUsers(Integer userId) {
		if (repository.existsById(userId)) {
	        repository.deleteById(userId);
	        return true;
	    } else {
	        return false;
	    }
	}

	@Override
	public boolean updateUsers(Integer userId, UsersDto dto) {
		Optional<Users> optionalUser = repository.findById(userId);
	    if (optionalUser.isPresent()) {
	        Users existingUser = optionalUser.get();
	        BeanUtils.copyProperties(dto, existingUser);
	        repository.save(existingUser);
	        return true;
	    } else {
	        return false;
	    }
	}
}