package com.rodatek.poc.example.domain;

import org.springframework.stereotype.Service;

import com.rodatek.common.business.service.AbstractBusinessService;
import com.rodatek.common.persistence.PersistenceService;

import com.rodatek.poc.example.persistence.impl.UserJpaPersistenceService;

//@Service
public class UserBusinessService extends AbstractBusinessService<UserDto> {
	
	private UserJpaPersistenceService dao;
	
	public UserBusinessService(PersistenceService<UserDto> serv) {
		super(serv);
		this.dao=(UserJpaPersistenceService) serv;
	}

}
