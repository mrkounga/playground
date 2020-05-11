package com.rodatek.example.user.repository.jpa;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.repository.jpa.BaseJpaRepository;
import com.rodatek.example.repository.jpacommon.Test_AbstractJpaRepository;
import com.rodatek.poc.example.repository.jpa.UserJpaEntity;
import com.rodatek.poc.example.repository.jpa.UserJpaRepository;

@DisplayName(value = "User Jpa repository Service")
class Test_UserJpaRepository  extends Test_AbstractJpaRepository<UserJpaEntity>{

	@Autowired
	private UserJpaRepository repository;
	

	@Override
	protected BaseJpaRepository<UserJpaEntity> getRepository() {		
		return repository;
	}

	@Override
	protected UserJpaEntity createEntity() {
		UserJpaEntity myUser = UserJpaEntity.builder().email("mrkounga@gmail.com").firstname("Michel").username("TheKoung").build();		
	return myUser;
	}

	@Override
	@Test
	@DisplayName("Test - Update Entity")
	public void testUpdate() {
		// Arrange
		UserJpaEntity createdEntity = entityManager.persist(createEntity());
		UserJpaEntity userToUpdate=UserJpaEntity.builder()
				.email("myNewEmail@gmail.com")
				.id(createdEntity.getId())
				.firstname(createdEntity.getFirstname())
				.username(createdEntity.getUsername())
				.build();
		// Act
		UserJpaEntity updatedUser = getRepository().saveAndFlush(userToUpdate);

		// Assert
		assertThat(updatedUser.getId()).isEqualTo(createdEntity.getId());
		assertThat(updatedUser.getEmail()).isNotEqualTo("mrkounga@gmail.com");
	}

	
	

}
