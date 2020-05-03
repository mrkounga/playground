package com.rodatek.example.persistenceservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.PersistenceDtoService;
import com.rodatek.common.persistence.config.PersitenceJpaServiceConfig;
import com.rodatek.example.businessdomain.UserDto;
import com.rodatek.example.model.impl.UserJpaEntity;
import com.rodatek.example.persistence.UserPersistenceService;
import com.rodatek.example.persitenceservice.common.Test_AbstractPersistenceService;

//@DataJpaTest
//@ContextConfiguration(classes = PersitenceJpaServiceConfig.class)
@SpringJUnitConfig()
@SpringBootTest
@DisplayName(value = "User Persistence Service")
class Test_UserPersistenceService extends Test_AbstractPersistenceService<UserDto> {

	@Autowired
	private UserPersistenceService userPersistenceService;
	
	@Override
	protected PersistenceDtoService<UserDto> getPeristenceService() {
		// TODO Auto-generated method stub
		return userPersistenceService;
	}

	@Override
	protected UserDto givenDto() {
		UserDto userDto = UserDto.builder().email("mrkounga@gmail.com").firstName("Michel").surname("Kounga")
				.username("TheKoung").build();
		return userDto;
	}

	@Override
	protected <E extends IEntity> E givenEntity() {
		UserJpaEntity userJpaEntity = UserJpaEntity.builder().id(3L).email("mrkounga@gmail.com").firstName("Michel")
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
		UserJpaEntity existingUser = givenEntity();
		// act
		UserDto loadedUser = userPersistenceService.convertToLayerObjectUp(existingUser);
		// assert
		assertThat(loadedUser.getId()).isEqualTo(existingUser.getId());

	}

	@Test
	@DisplayName("Test - Persistence Service : Convert Dto to Entity")
	protected void testConvertToLayerObjectDown() {
		// arrange
		UserDto newUser = givenDto();
		UserJpaEntity userJpaEntity = null;

		// act - convert to entity
		userJpaEntity = userPersistenceService.convertToLayerObjectDown(newUser);

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

	
}
