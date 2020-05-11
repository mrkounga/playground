package com.rodatek.poc.example.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.restapi.AbstractResourceToDtoService;
import com.rodatek.poc.example.businessdomain.UserDto;

@Service
@Transactional
public class UserResourceService extends AbstractResourceToDtoService<UserResource,UserDto> {
	
	private BusinessService<UserDto> service;

	public UserResourceService(BusinessService<UserDto> serviceToSet) {
		super(serviceToSet);
		this.service=serviceToSet;
	}

	@Override
	public UserResource convertDtoToResource(UserDto userDto) {

		return UserResource.builder()
				.id(userDto.getId())
				.email(userDto.getEmail())
				.firstname(userDto.getFirstname())
				.username(userDto.getUsername())
				.surname(userDto.getSurname())				
				.build();
	}

	@Override
	public UserDto convertResourceToDto(UserResource userResource) {
		
		return UserDto.builder()
				.id(userResource.getId())
				.email(userResource.getEmail())
				.firstname(userResource.getFirstname())
				.username(userResource.getUsername())
				.surname(userResource.getSurname())
				.build();
	}

}
