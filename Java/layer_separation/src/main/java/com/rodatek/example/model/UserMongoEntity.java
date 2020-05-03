package com.rodatek.example.model;

import com.rodatek.common.persistence.mongo.MongoEntity;

import lombok.Value;

@Value
public final class UserMongoEntity implements MongoEntity {
	private Long id;
	private final String username;
	private final String surname;
	private final String firstName;
	private final String email;
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

}
