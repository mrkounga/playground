package com.rodatek.poc.example.persistence.impl;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.mybatis.AbstractDtoMyBatisPersistenceService;
import com.rodatek.poc.example.domain.UserDto;
import com.rodatek.poc.example.model.UserEntity;
import com.rodatek.poc.example.repository.mybatis.UserMyBastisRepository;

@Service
@Profile("mybatisrepo")
public class UserMyBatisPersistenceService extends AbstractDtoMyBatisPersistenceService<UserDto,UserEntity>  {

	private final UserMyBastisRepository repository;
	
	public UserMyBatisPersistenceService(UserMyBastisRepository repo) {
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
