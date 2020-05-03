package com.rodatek.example.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.jpa.AbstractDtoJpaEntityPersistenceService;
import com.rodatek.common.repository.jpa.BaseJpaRepository;
import com.rodatek.example.businessdomain.UserDto;
import com.rodatek.example.model.impl.UserJpaEntity;
import com.rodatek.example.repository.UserJpaRepository;

@Repository
public class UserPersistenceService extends AbstractDtoJpaEntityPersistenceService<UserDto,UserJpaEntity>{

	private UserJpaRepository repo;
	
	public UserPersistenceService(BaseJpaRepository<UserJpaEntity> repository) {
		super(repository);
		this.repo=(UserJpaRepository) repository;
	}

	@Override
	public UserDto convertToLayerObjectUp(UserJpaEntity resourceToConvert) {
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
	public UserJpaEntity convertToLayerObjectDown(UserDto resourceToConvert) {		
		return resourceToConvert.getId()!=null?UserJpaEntity.builder()
				.id(resourceToConvert.getId())  
				.email(resourceToConvert.getEmail())
				.firstName(resourceToConvert.getFirstName())				
				.username(resourceToConvert.getUsername())
				.build()
				:UserJpaEntity.builder()				
				.email(resourceToConvert.getEmail())
				.firstName(resourceToConvert.getFirstName())				
				.username(resourceToConvert.getUsername())
				.build();
	}

}
