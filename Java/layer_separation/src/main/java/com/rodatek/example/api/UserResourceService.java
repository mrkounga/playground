package com.rodatek.example.api;

import org.springframework.stereotype.Service;

import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.restapi.AbstractResourceDtoService;
import com.rodatek.example.businessdomain.UserDto;

@Service
public class UserResourceService extends AbstractResourceDtoService<UserResource,UserDto> {
	

	public UserResourceService(BusinessService<UserDto> serviceToSet) {
		super(serviceToSet);
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserResource convertToLayerObjectUp(UserDto resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto convertToLayerObjectDown(UserResource resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

}
