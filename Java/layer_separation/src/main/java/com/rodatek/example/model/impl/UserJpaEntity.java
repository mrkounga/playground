package com.rodatek.example.model.impl;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.rodatek.common.repository.jpa.JpaEntity;
import com.rodatek.domain.user.User;

import lombok.Builder;
import lombok.Value;

@Entity
@Value
@Builder
public final class UserJpaEntity implements User, JpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final  Long id;
	@Email
	private final String email;
	private final String firstName;
	private final String username;
	
	private UserJpaEntity() {
		this.id=null;
		this.email=null;
		this.firstName=null;
		this.username=null;	
	}
	
	private UserJpaEntity(Long id,String email,String firstname, String username) {
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
