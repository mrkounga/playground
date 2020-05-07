package com.rodatek.example.persistenceservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.PersistenceService;
import com.rodatek.example.persitenceservice.common.Test_AbstractPersistenceService;
import com.rodatek.poc.example.domain.UserDto;
import com.rodatek.poc.example.model.UserEntity;
import com.rodatek.poc.example.persistence.impl.UserJpaPersistenceService;


@DisplayName(value = "User Persistence Service")
//@Profile("jpa")
class Test_UserPersistenceService extends Test_AbstractPersistenceService<UserDto> {

	@Autowired
	private PersistenceService<UserDto> userPersistenceService;
	

	@Override
	protected UserDto givenDto() {
		UserDto userDto = UserDto.builder().email("mrkounga@gmail.com").firstName("Michel").surname("Kounga")
				.username("TheKoung").build();
		return userDto;
	}

	@Override
	protected <E extends IEntity> E givenEntity() {
		UserEntity userJpaEntity = UserEntity.builder().id(3L).email("mrkounga@gmail.com").firstName("Michel")
				.username("TheKoung").build();
		return (E) userJpaEntity;
	}
	
	@Test
	@DisplayName("Test - Check Persistence Service not null")
	void init() {
		assertThat(userPersistenceService).isNotNull();
	}

	@Test
	@DisplayName("Test - Persistence Service : Convert Entity to Dto")
	@Override
	protected void testConvertToLayerObjectUp() {
		// Arrange
		UserEntity existingUser = givenEntity();
		// act
	//	UserDto loadedUser = userPersistenceService.convertEntityToDto(existingUser);
		// assert
		//assertThat(loadedUser.getId()).isEqualTo(existingUser.getId());

	}

	@Test
	@DisplayName("Test - Persistence Service : Convert Dto to Entity")
	protected void testConvertToLayerObjectDown() {
		// arrange
		UserDto newUser = givenDto();
		UserEntity userJpaEntity = null;

		// act - convert to entity
		//userJpaEntity = userPersistenceService.convertDtoToEntity(newUser);

		// assert
		assertThat(userJpaEntity.getEmail()).isEqualTo(newUser.getEmail());
		assertThat(userJpaEntity.getId()).isNull();

	}

	@Test
	@DisplayName("Test - Persistence Service : Update Entity")
	protected void testUpdate() {
		// Arrange
		UserDto createdUser = userPersistenceService.create(givenDto());
		UserDto userToUpdate = UserDto.builder().id(createdUser.getId()).email("NewEmail@IamNew.com")
				.firstName(createdUser.getFirstName()).surname(createdUser.getSurname()).build();
		// Act
		userPersistenceService.update(userToUpdate);

		// Assert
		assertThat(userToUpdate.getId()).isEqualTo(createdUser.getId());
		assertThat(userToUpdate.getEmail()).isNotEqualTo(createdUser.getEmail());
	}

	@Override
	protected PersistenceService<UserDto> getPeristenceService() {
		// TODO Auto-generated method stub
		return userPersistenceService;
	}

	

	
}
