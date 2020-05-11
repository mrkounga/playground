package com.rodatek.poc.example.domain;

import org.springframework.stereotype.Service;

import com.rodatek.common.business.service.AbstractBusinessService;
import com.rodatek.common.persistence.PersistenceService;

@Service
public class UserServiceImpl extends AbstractBusinessService<UserDto> implements UserService {
	
	private PersistenceService dao;
	
	public UserServiceImpl(PersistenceService<UserDto> serv) {
		super(serv);
		this.dao= serv;
	}

}
