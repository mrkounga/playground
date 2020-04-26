package com.rodatek.poc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.rodatek.common.model.JpaEntity;

import lombok.Value;

@Entity
@Value
public  final class UserEntity implements JpaEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Long id;
	private final String username;
	private final String surname;
	private final String firstName;
	private final String email;

}
