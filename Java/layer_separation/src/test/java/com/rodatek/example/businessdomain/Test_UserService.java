package com.rodatek.example.businessdomain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.rodatek.common.business.service.BusinessService;
import com.rodatek.common.business.service.Test_AbstractBusinessService;
import com.rodatek.poc.example.businessdomain.UserDto;


@DisplayName("Test - Business Service : UserService")
public class Test_UserService extends Test_AbstractBusinessService<UserDto>{
	
	@Autowired
	private BusinessService<UserDto> service;

	@Override
	protected BusinessService<UserDto> getService() {
		return service;
	}

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
	@DisplayName("Test -  Service : Update Entity")
	protected void testUpdate() {
		// Arrange
		UserDto createdUser = getService().create(givenDto());
		UserDto userToUpdate = UserDto.builder().id(createdUser.getId()).email("NewEmail@IamNew.com")
				.firstname(createdUser.getFirstname()).surname(createdUser.getSurname()).build();
		// Act
		getService().update(userToUpdate);

		// Assert
		assertThat(userToUpdate.getId()).isEqualTo(createdUser.getId());
		assertThat(userToUpdate.getEmail()).isNotEqualTo(createdUser.getEmail());
	}

	
}
