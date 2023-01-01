package com.example.simpleauth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public final class UserDto {

	private final String login;
	private final String name;

}
