package com.rodatek.poc.persistence;

import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.jpa.AbstractDtoJpaEntityPersistenceService;
import com.rodatek.common.persistence.jpa.AbstractPersistenceJpaEntityService;
import com.rodatek.common.persistence.jpa.BaseJpaRepository;
import com.rodatek.poc.businessdomain.UserDto;
import com.rodatek.poc.model.impl.UserJpaEntity;
import com.rodatek.poc.repository.UserJpaRepository;

@Service
public class UserPersistenceService extends AbstractDtoJpaEntityPersistenceService<UserDto,UserJpaEntity>{

	private UserJpaRepository repo;
	
	public UserPersistenceService(BaseJpaRepository<UserJpaEntity> repository) {
		super(repository);
		this.repo=(UserJpaRepository) repository;
	}

	@Override
	public UserDto convertToLayerObjectUp(UserJpaEntity resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserJpaEntity convertToLayerObjectDown(UserDto resourceToConvert) {
		// TODO Auto-generated method stub
		return null;
	}

}
