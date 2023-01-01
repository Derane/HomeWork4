package com.example.simpleauth.repo;

import com.example.simpleauth.entity.User;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class InMemoryUserRepository {

	private static final InMemoryUserRepository INSTANCE = new InMemoryUserRepository();

	private InMemoryUserRepository() {
	}

	private final List<User> userList = List.of(User.builder()
					.login("Valera2020")
					.name("Valerii")
					.password("123123")
					.build(),
			User.builder()
					.login("Sokol")
					.name("Ruslan")
					.password("256256")
					.build());


	public List<User> findAll() {
		return userList;
	}

	public Optional<User> findByLoginAndPassword(String login, String password) {
		return userList.stream()
				.filter(user -> Objects.equals(user.getLogin(), login) && Objects.equals(user.getPassword(), password))
				.findFirst();
	}


	public static InMemoryUserRepository getInstance() {
		return INSTANCE;
	}
}
