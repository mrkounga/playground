package com.rodatek.poc.example.persistence.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.mybatis.AbstractDtoSqlEntityPersistenceService;
import com.rodatek.poc.example.businessdomain.UserDto;
import com.rodatek.poc.example.repository.jpa.UserJpaEntity;
import com.rodatek.poc.example.repository.mybatis.UserEntity;
import com.rodatek.poc.example.repository.mybatis.UserMyBatisRepository;


@Service
@Profile("mybatisrepo")
public class UserMyBatisPersistenceService extends AbstractDtoSqlEntityPersistenceService<UserDto,UserEntity>  {

	private final UserMyBatisRepository repository;
	
	public UserMyBatisPersistenceService(UserMyBatisRepository repo) {
		super(repo);
		this.repository=repo;
	}
	@Override
	public UserDto convertEntityToDto(UserEntity resourceToConvert) {
			return resourceToConvert.getId()!=null?UserDto.builder()
					.id(Long.toString(resourceToConvert.getId()))
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())
					.surname(resourceToConvert.getUsername())
					.username(resourceToConvert.getUsername())
					.build()
					:null;	
		}

	@Override
	public UserEntity convertDtoToEntity(UserDto resourceToConvert) {		
			return resourceToConvert.getId()!=null?UserEntity.builder()
					.id(Long.parseLong(resourceToConvert.getId()) )
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.build()
					:UserEntity.builder()				
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.build();
		}
	
	
}
