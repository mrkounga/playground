package com.rodatek.example.user.repository.jpa;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.repository.jpa.BaseJpaRepository;
import com.rodatek.example.model.impl.UserJpaEntity;
import com.rodatek.example.repository.UserJpaRepository;
import com.rodatek.example.repository.jpacommon.Test_AbstractJpaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
class Test_UserJpaRepository  extends Test_AbstractJpaRepository<UserJpaEntity>{

	@Autowired
	private UserJpaRepository repository;
	

	@Override
	protected BaseJpaRepository<UserJpaEntity> getRepository() {		
		return repository;
	}

	@Override
	protected UserJpaEntity createEntity() {
		UserJpaEntity myUser = UserJpaEntity.builder().email("mrkounga@gmail.com").firstName("Michel").username("TheKoung").build();		
	return myUser;
	}

	@Override
	@Test
	@DisplayName("Test - Update Entity")
	public void testUpdate() {
		// Arrange
		UserJpaEntity createdEntity = entityManager.persist(createEntity());
		log.info(">>>>>>>>>>>>>> Email found : "+createdEntity.getEmail());
		UserJpaEntity userToUpdate=UserJpaEntity.builder()
				.email("myNewEmail@gmail.com")
				.id(createdEntity.getId())
				.firstName(createdEntity.getFirstName())
				.username(createdEntity.getUsername())
				.build();
		log.info(">>>>>>>>>>>>>> Email found : "+userToUpdate.getEmail());
		// Act
		UserJpaEntity updatedUser = getRepository().saveAndFlush(userToUpdate);

		// Assert
		assertThat(updatedUser.getId()).isEqualTo(createdEntity.getId());
		assertThat(updatedUser.getEmail()).isNotEqualTo("mrkounga@gmail.com");
	}

	
	

}
