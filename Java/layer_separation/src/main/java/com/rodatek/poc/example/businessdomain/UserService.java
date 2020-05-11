package com.rodatek.poc.example.businessdomain;



import org.springframework.stereotype.Service;

import com.rodatek.common.business.service.AbstractBusinessService;
import com.rodatek.common.persistence.PersistenceService;

@Service
public class UserService extends AbstractBusinessService<UserDto> implements IUserService {
	
	private PersistenceService<UserDto> service;
	
	public UserService(PersistenceService<UserDto> serv) {
		super(serv);
		this.service=serv;
	}

}
