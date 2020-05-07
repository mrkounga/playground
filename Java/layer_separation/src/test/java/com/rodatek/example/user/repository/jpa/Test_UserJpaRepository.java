package com.rodatek.example.user.repository.jpa;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.repository.BaseRepository;
import com.rodatek.common.repository.jpa.BaseJpaRepository;
import com.rodatek.example.repository.jpacommon.Test_AbstractJpaRepository;
import com.rodatek.poc.example.model.UserEntity;
import com.rodatek.poc.example.repository.jpa.UserJpaRepository;

import lombok.extern.log4j.Log4j2;

@DisplayName(value = "User Jpa repository Service")
class Test_UserJpaRepository  extends Test_AbstractJpaRepository<UserEntity>{

	@Autowired
	private UserJpaRepository repository;
	

	@Override
	protected BaseJpaRepository<UserEntity> getRepository() {		
		return repository;
	}

	@Override
	protected UserEntity createEntity() {
		UserEntity myUser = UserEntity.builder().email("mrkounga@gmail.com").firstName("Michel").username("TheKoung").build();		
	return myUser;
	}

	@Override
	@Test
	@DisplayName("Test - Update Entity")
	public void testUpdate() {
		// Arrange
		UserEntity createdEntity = entityManager.persist(createEntity());
		UserEntity userToUpdate=UserEntity.builder()
				.email("myNewEmail@gmail.com")
				.id(createdEntity.getId())
				.firstName(createdEntity.getFirstName())
				.username(createdEntity.getUsername())
				.build();
		// Act
		UserEntity updatedUser = getRepository().saveAndFlush(userToUpdate);

		// Assert
		assertThat(updatedUser.getId()).isEqualTo(createdEntity.getId());
		assertThat(updatedUser.getEmail()).isNotEqualTo("mrkounga@gmail.com");
	}

	
	

}
