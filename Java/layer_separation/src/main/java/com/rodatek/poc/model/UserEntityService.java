package com.rodatek.poc.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.model.AbstractEntityService;
import com.rodatek.common.persistence.PersistenceService;


@Service
public class UserEntityService extends AbstractEntityService<UserEntity>{

	public UserEntityService(@Qualifier("jpa") PersistenceService<UserEntity> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	
}
