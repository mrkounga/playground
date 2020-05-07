package com.rodatek.poc.example.api;

import org.springframework.stereotype.Service;

import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.restapi.AbstractResourceDtoService;
import com.rodatek.poc.example.domain.UserDto;

//@Service
public class UserResourceService extends AbstractResourceDtoService<UserResource,UserDto> {
	
	private BusinessService<UserDto> service;

	public UserResourceService(BusinessService<UserDto> serviceToSet) {
		super(serviceToSet);
		this.service=serviceToSet;
	}

	@Override
	public UserResource convertToLayerObjectUp(UserDto userDto) {
		
		// TODO Auto-generated method stub
		return UserResource.builder()
				.id(userDto.getId())
				.email(userDto.getEmail())
				.firstName(userDto.getFirstName())
				.surname(userDto.getUsername())
				.fullName(userDto.getFirstName()+" "+userDto.getUsername())
				.build();
	}

	@Override
	public UserDto convertToLayerObjectDown(UserResource userResource) {
		
		return UserDto.builder()
				.id(userResource.getId())
				.email(userResource.getEmail())
				.firstName(userResource.getFirstName())
				.surname(userResource.getUsername())
				.build();
	}

}
