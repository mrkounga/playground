package com.rodatek.poc.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;

import com.rodatek.common.model.IEntity;
import com.rodatek.domain.user.User;

import lombok.Builder;
import lombok.Value;

@Entity
@Value
@Builder
@Component
public final class UserEntity implements User, IEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final  Long id;
	@Email
	private final String email;
	private final String firstName;
	private final String username;
	
	private UserEntity() {
		this.id=null;
		this.email=null;
		this.firstName=null;
		this.username=null;	
	}
	
	private UserEntity(Long id,String email,String firstname, String username) {
		this.id=id;
		this.email=email;
		this.firstName=firstname;
		this.username=username;
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}


	
	
}
