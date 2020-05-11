package com.rodatek.poc.example.persistence.impl;


import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.rodatek.common.persistence.jpa.AbstractDtoJpaEntityPersistenceService;
import com.rodatek.poc.example.businessdomain.UserDto;
import com.rodatek.poc.example.repository.jpa.UserJpaEntity;
import com.rodatek.poc.example.repository.jpa.UserJpaRepository;

@Service
@Profile("jparepo")
public class UserJpaPersistenceService extends AbstractDtoJpaEntityPersistenceService<UserDto,UserJpaEntity>   {

	private final UserJpaRepository repository;
	
	public UserJpaPersistenceService(UserJpaRepository repo) {
		super(repo);
		this.repository=repo;
	}

	@Override //throw exception
	public UserDto convertEntityToDto(UserJpaEntity resourceToConvert) {
			return resourceToConvert.getId()!=null?UserDto.builder()
					.id(Long.toString(resourceToConvert.getId()))
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())
					.surname(resourceToConvert.getSurname())
					.username(resourceToConvert.getUsername())
					.build()
					:null;	
		}

	@Override //throw exception
	public UserJpaEntity convertDtoToEntity(UserDto resourceToConvert) {		
			return resourceToConvert.getId()!=null?UserJpaEntity.builder()
					.id(Long.parseLong(resourceToConvert.getId()) )
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.surname(resourceToConvert.getSurname())
					.build()
					:UserJpaEntity.builder()				
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.surname(resourceToConvert.getSurname())
					.build();
		}

	
	
}
