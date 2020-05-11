package com.rodatek.example.persistenceservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.persistence.jpa.PersistenceJpaEntityService;
import com.rodatek.common.persistence.jpa.Test_AbstractDtoJpaEntityPersistenceService;
import com.rodatek.poc.example.businessdomain.UserDto;
import com.rodatek.poc.example.persistence.impl.UserJpaPersistenceService;
import com.rodatek.poc.example.repository.jpa.UserJpaEntity;

@DisplayName(value = "User Persistence Service")
class Test_UserJpaEntityPersistenceService extends Test_AbstractDtoJpaEntityPersistenceService<UserDto,UserJpaEntity> {

	@Autowired
	private UserJpaPersistenceService service;

	@Override
	protected UserDto givenDto() {
		UserDto userDto = UserDto.builder().email("mrkounga@gmail.com").firstname("Michel").surname("Kounga")
				.username("TheKoung").build();
		return userDto;
	}
	
	protected  List<UserDto> givenListDtos() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (int i = 0; i < 10; i++) {
			dtos.add(givenDto());
		}
		return dtos;
	}
	

	
	@Test
	@DisplayName("Test - Persistence Service : Update Entity")
	protected void testUpdate() {
		// Arrange
		UserDto createdUser = getPersistenceService().create(givenDto());
		UserDto userToUpdate = UserDto.builder().id(createdUser.getId()).email("NewEmail@IamNew.com")
				.firstname(createdUser.getFirstname()).surname(createdUser.getSurname()).build();
		// Act
		getPersistenceService().update(userToUpdate);

		// Assert
		assertThat(userToUpdate.getId()).isEqualTo(createdUser.getId());
		assertThat(userToUpdate.getEmail()).isNotEqualTo(createdUser.getEmail());
	}

	

	@Override
	protected PersistenceJpaEntityService<UserDto, UserJpaEntity> getPersistenceService() {
		return service;
	}
	
	

	

}
