package com.rodatek.poc.example.api;

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
	private String firstName;

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
	
	public UserResource() {
		this.id=null;
		this.email=null;
		this.firstName=null;
		this.username=null;
		this.surname=null;
		this.fullName=null;
	}
	
	public UserResource(Long id,String email, String firstname, String username, String surname, String fullname) {
		this.id=id;
		this.email=email;
		this.firstName=firstname;
		this.username=username;
		this.surname=surname;
		this.fullName=fullname;
	}

}
