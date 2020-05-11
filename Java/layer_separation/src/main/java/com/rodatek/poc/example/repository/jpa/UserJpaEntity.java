package com.rodatek.poc.example.repository.jpa;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.model.JpaEntity;
import com.rodatek.domain.user.User;

import lombok.Builder;
import lombok.Value;

@Entity
@Value
@Builder
@Table(name="ROTATEK_USERS")
public final class UserJpaEntity implements User, JpaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final  Long id;
	//@Email
	private final String email;
	private final String firstname;
	private final String username;
	private final String surname;
	
	private UserJpaEntity() {
		this.id=null;
		this.email=null;
		this.firstname=null;
		this.username=null;	
		this.surname=null;
	}
	
	private UserJpaEntity(Long id,String email,String firstname, String username,String surname) {
		this.id=id;
		this.email=email;
		this.firstname=firstname;
		this.username=username;
		this.surname=surname;
	}
	
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	
	
}
