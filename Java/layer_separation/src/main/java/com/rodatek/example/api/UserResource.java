package com.rodatek.example.api;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rodatek.common.restapi.IResource;
import com.rodatek.domain.user.User;

import lombok.Builder;
import lombok.Value;

@Validated
@Builder
@Value
public class UserResource implements User, IResource {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("username")
	private String username;

	@JsonProperty("firstname")
	private String firstname;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("fullName")
	private String fullName;

	@JsonProperty("email")
	private String email;

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFirsName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
