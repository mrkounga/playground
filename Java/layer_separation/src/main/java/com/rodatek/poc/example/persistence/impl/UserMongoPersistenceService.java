package com.rodatek.poc.example.persistence.impl;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.mongo.AbstractDtoMongoEntityPersistenceService;
import com.rodatek.poc.example.domain.UserDto;
import com.rodatek.poc.example.model.UserEntity;
import com.rodatek.poc.example.repository.mongo.UserMongoRepository;

@Service
@Profile("mongorepo")
public class UserMongoPersistenceService extends AbstractDtoMongoEntityPersistenceService<UserDto,UserEntity>  {

	private final UserMongoRepository repository;
	
	public UserMongoPersistenceService(UserMongoRepository repo) {
		super(repo);
		this.repository=repo;
	}

	@Override
	public UserDto convertEntityToDto(UserEntity resourceToConvert) {
			return resourceToConvert.getId()!=null?UserDto.builder()
					.id(resourceToConvert.getId())
					.email(resourceToConvert.getEmail())
					.firstName(resourceToConvert.getFirstName())
					.surname(resourceToConvert.getUsername())
					.username(resourceToConvert.getUsername())
					.build()
					:null;	
		}

	@Override
	public UserEntity convertDtoToEntity(UserDto resourceToConvert) {		
			return resourceToConvert.getId()!=null?UserEntity.builder()
					.id(resourceToConvert.getId())  
					.email(resourceToConvert.getEmail())
					.firstName(resourceToConvert.getFirstName())				
					.username(resourceToConvert.getUsername())
					.build()
					:UserEntity.builder()				
					.email(resourceToConvert.getEmail())
					.firstName(resourceToConvert.getFirstName())				
					.username(resourceToConvert.getUsername())
					.build();
		}

	
	
}
