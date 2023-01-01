package com.example.simpleauth.service;

import com.example.simpleauth.InMemoryUserRepository;
import com.example.simpleauth.dto.UserDto;

import java.util.List;
import java.util.Optional;

public class UserService {

	private static final UserService INSTANCE = new UserService();

	private final InMemoryUserRepository userDao = InMemoryUserRepository.getInstance();

	private UserService() {
	}

	public Optional<UserDto> login(String email, String password) {
		return userDao.findByLoginAndPassword(email, password)
				.map(user -> new UserDto(user.getLogin(), user.getName()));
	}

	public List<UserDto> getAll() {
		return userDao.findAll().stream()
				.map(user -> new UserDto(user.getLogin(), user.getName()))
				.toList();
	}

	public static UserService getInstance() {
		return INSTANCE;
	}

}
