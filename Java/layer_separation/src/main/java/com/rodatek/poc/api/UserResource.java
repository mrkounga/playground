package com.rodatek.poc.api;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rodatek.common.restapi.IResource;

import lombok.Value;

@Validated
@Value
public class UserResource implements IResource {

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
	
	
}
