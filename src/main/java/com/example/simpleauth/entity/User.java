package com.example.simpleauth.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private String login;

	private String name;

	private String password;
}
