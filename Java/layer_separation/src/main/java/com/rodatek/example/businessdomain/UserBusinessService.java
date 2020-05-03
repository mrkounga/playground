package com.rodatek.example.businessdomain;

import org.springframework.stereotype.Service;

import com.rodatek.common.business.service.AbstractBusinessService;
import com.rodatek.common.persistence.PersistenceDtoService;
import com.rodatek.example.persistence.UserPersistenceService;

@Service
public class UserBusinessService extends AbstractBusinessService<UserDto> {
	
	private UserPersistenceService persitenceService;

	public UserBusinessService(PersistenceDtoService<UserDto> serv) {
		super(serv);
		//this.persitenceService=serv;
	}
	

}
