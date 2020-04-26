package com.rodatek.poc.model;

import com.rodatek.common.model.MongoEntity;

import lombok.Value;

@Value
public final class UserMongoEntity implements MongoEntity {
	private Long id;
	private final String username;
	private final String surname;
	private final String firstName;
	private final String email;

}
