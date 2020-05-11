package com.rodatek.poc.example.repository.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rodatek.common.model.MongoEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Document
 @Builder 
 @Data
public class UserMongoEntity implements MongoEntity{

	@Id
	private String id;
	private final String email;
	private final String firstname;
	private final  String username;
	
	public UserMongoEntity(String id,String email,String firstname, String username) {
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
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
}
