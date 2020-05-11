package com.rodatek.poc.example.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rodatek.common.restapi.ReourceDtoControllerService;
import com.rodatek.common.restapi.Test_AbstractResourceToDtoService;
import com.rodatek.poc.example.businessdomain.UserDto;

import lombok.extern.log4j.Log4j2;

@DisplayName("Test - UserResourceService")
@EnableTransactionManagement
class Test_UserResourceService extends Test_AbstractResourceToDtoService<UserResource, UserDto> {

	@Autowired
	private UserResourceService resourceService;

	@Override
	protected UserResource givenResource() {
		UserResource userResource = UserResource.builder().email("mrkounga@gmail.com").firstname("Michel")
				.surname("Kounga").username("TheKoung").build();
		return userResource;
	}

	@Override
	protected List<UserResource> givenListResources() {
		List<UserResource> resources = new ArrayList<UserResource>();
		for (int i = 0; i < 10; i++) {
			resources.add(givenResource());
		}
		return resources;
	}

	@Test
	@DisplayName("Test -  Controller Service : Update Entity")
	protected void testUpdateResource() {
		// Arrange
		UserResource createdUser = getControllerService().createResource(givenResource());
		UserResource userToUpdate = UserResource.builder().id(createdUser.getId()).email("NewEmail@IamNew.com")
				.firstname(createdUser.getFirstname()).surname(createdUser.getSurname()).build();
		// Act
		UserResource newlyCreatedUser=getControllerService().updateResource(userToUpdate);
		
		// Assert
		assertThat(userToUpdate.getId()).isEqualTo(createdUser.getId());
		assertThat(userToUpdate.getEmail()).isNotEqualTo(createdUser.getEmail());
	}

	@Override
	protected ReourceDtoControllerService<UserResource, UserDto> getControllerService() {
		return resourceService;
	}

}
