package com.rodatek.poc.domain;

import org.springframework.stereotype.Service;

import com.rodatek.common.converter.AbstractDtoEntityConverter;
import com.rodatek.common.model.EntityService;
import com.rodatek.poc.model.UserEntity;

@Service
public class UserDtoService extends AbstractDtoEntityConverter<UserDto, UserEntity> {

	public UserDtoService(EntityService<UserEntity> entityService) {
		super(entityService);
		// TODO Auto-generated constructor stub
	}

	public UserDto convertToLayerObjectUp(UserEntity resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEntity convertToLayerObjectDown(UserDto resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

}
