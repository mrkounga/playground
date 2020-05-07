package com.rodatek.poc.example.persistence.impl;

import com.rodatek.common.persistence.converter.DtoEntityConverter;
import com.rodatek.poc.example.domain.UserDto;
import com.rodatek.poc.example.model.UserEntity;

public class UserDtoEntityConverter implements DtoEntityConverter<UserDto, UserEntity> {

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
