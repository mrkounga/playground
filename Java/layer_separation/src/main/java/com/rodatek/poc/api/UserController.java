package com.rodatek.poc.api;

import org.springframework.stereotype.Service;

import com.rodatek.common.converter.AbstractResourceDtoConverter;
import com.rodatek.common.domain.DtoService;
import com.rodatek.poc.domain.UserDto;

@Service
public class UserControllerService extends AbstractResourceDtoConverter<UserResource, UserDto>{

	public UserControllerService(DtoService<UserDto> dService) {
		super(dService);
	}

	public UserResource convertToLayerObjectUp(UserDto resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDto convertToLayerObjectDown(UserResource resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
