package com.rodatek.example.user.persistence.jpa;





import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.persistence.jpa.BaseJpaRepository;
import com.rodatek.example.model.impl.UserJpaEntity;
import com.rodatek.example.repository.UserJpaRepository;
import com.rodatek.example.repository.jpacommon.Test_AbstractJpaRepository;

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
