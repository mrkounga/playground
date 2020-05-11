package com.rodatek.poc.example.persistence.impl;

import com.rodatek.common.persistence.converter.DtoEntityConverter;
import com.rodatek.poc.example.businessdomain.UserDto;
import com.rodatek.poc.example.repository.jpa.UserJpaEntity;

public class UserDtoEntityConverter implements DtoEntityConverter<UserDto, UserJpaEntity> {

	@Override
	public UserDto convertEntityToDto(UserJpaEntity resourceToConvert) {
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
	public UserJpaEntity convertDtoToEntity(UserDto resourceToConvert) {		
			return resourceToConvert.getId()!=null?UserJpaEntity.builder()
					.id(Long.parseLong(resourceToConvert.getId()) )
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.build()
					:UserJpaEntity.builder()				
					.email(resourceToConvert.getEmail())
					.firstname(resourceToConvert.getFirstname())				
					.username(resourceToConvert.getUsername())
					.build();
		}

}
