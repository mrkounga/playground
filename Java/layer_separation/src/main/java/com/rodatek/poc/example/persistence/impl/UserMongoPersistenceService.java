package com.rodatek.poc.example.persistence.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.mongo.AbstractDtoMongoEntityPersistenceService;
import com.rodatek.poc.example.businessdomain.UserDto;
import com.rodatek.poc.example.repository.jpa.UserJpaEntity;
import com.rodatek.poc.example.repository.mongo.UserMongoEntity;
import com.rodatek.poc.example.repository.mongo.UserMongoRepository;

@Service
@Profile("mongorepo")
public class UserMongoPersistenceService extends AbstractDtoMongoEntityPersistenceService<UserDto,UserMongoEntity>  {

	private final UserMongoRepository repository;
	
	public UserMongoPersistenceService(UserMongoRepository repo) {
		super(repo);
		this.repository=repo;
	}

	@Override
	public UserDto convertEntityToDto(UserMongoEntity resourceToConvert) {
			return resourceToConvert.getId()!=null?UserDto.builder()
					.id(resourceToConvert.getId())
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())
					.surname(resourceToConvert.getUsername())
					.username(resourceToConvert.getUsername())
					.build()
					:null;	
		}

	@Override
	public UserMongoEntity convertDtoToEntity(UserDto resourceToConvert) {		
			return resourceToConvert.getId()!=null?UserMongoEntity.builder()
					.id(resourceToConvert.getId())  
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.build()
					:UserMongoEntity.builder()				
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.build();
		}

	

	
	
}
