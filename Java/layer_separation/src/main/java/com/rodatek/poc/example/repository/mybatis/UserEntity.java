package com.rodatek.poc.example.repository.mybatis;


import com.rodatek.common.model.SqlEntity;

import lombok.Builder;
import lombok.Value;

@Value @Builder
public final class UserEntity implements SqlEntity{

	private final Long id;
	private final String email;
	private final String firstname;
	private final String username;
	
	
	public UserEntity(Long id,String email,String firstname, String username) {
		this.id=id;
		this.email=email;
		this.firstname=firstname;
		this.username=username;
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
