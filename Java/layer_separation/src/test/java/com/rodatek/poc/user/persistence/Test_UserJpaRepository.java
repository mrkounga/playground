package com.rodatek.poc.user.persistence;





import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.persistence.jpa.BaseJpaRepository;
import com.rodatek.poc.model.UserEntity;
import com.rodatek.poc.model.impl.UserJpaEntity;
import com.rodatek.poc.repository.UserJpaRepository;
import com.rodatek.poc.repository.jpacommon.Test_AbstractJpaRepository;

class Test_UserJpaRepository  extends Test_AbstractJpaRepository<UserJpaEntity>{

	@Autowired
	private UserJpaRepository repository;
	
	@Override
	protected BaseJpaRepository<UserJpaEntity> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}


	@Override
	protected UserJpaEntity createEntity() {
		UserJpaEntity myUser = UserJpaEntity.builder().email("mrkounga@gmail.com").firsName("Michel").username("TheKoung").build();
	return myUser;
	}

	

}
