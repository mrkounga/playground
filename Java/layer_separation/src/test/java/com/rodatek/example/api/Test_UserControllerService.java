package com.rodatek.example.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.restapi.ControllerService;
import com.rodatek.example.api.common.Test_AbstractControllerService;
import com.rodatek.example.businessdomain.UserDto;

@SpringJUnitConfig()
@SpringBootTest
@DisplayName(value = "Test - User Resource Service")
class Test_UserControllerService  extends Test_AbstractControllerService<UserResource>{
	
	@Autowired
	private UserResourceService resourceService;
	
	@Test
	@DisplayName("Test - Resource Service : Init")
	void init() {
		assertThat(resourceService).isNotNull();
	}

	@Test
	@DisplayName("Test - Resource Service : Convert Dto to Resource")
	protected void testConvertToLayerObjectUp() {
		//Arrange
		
		//Act
		UserResource userResource=resourceService.convertToLayerObjectUp(givenDto());
		
		//Assert
		assertThat(userResource.getId()).isEqualTo(givenDto().getId());		
	}

	@Test
	@DisplayName("Test - Resource Service : Convert Resource to Dto")
	protected void testConvertToLayerObjectDown() {
		//Arrange
		
		//Act
		UserDto userDto=resourceService.convertToLayerObjectDown(givenResource());
		
		//Assert
		assertThat(userDto.getId()).isEqualTo(givenResource().getId());
		
	}

	

	@Test
	@DisplayName("Test - Resource Service : Update Resource")
	void testUpdateResource() {
		UserResource createdResource=resourceService.createResource(givenResource());
		UserResource toUpdate=UserResource.builder()
				.id(createdResource.getId())
				.email("myUpdateEmail@fake.com")
				.firstName(createdResource.getFirstName())
				.surname(createdResource.getSurname())
				.build();
		
		toUpdate=resourceService.updateResource(toUpdate);
	}

	@Override
	protected ControllerService<UserResource> getControllerService() {
		return resourceService;
	}

	@Override
	protected UserResource givenResource() {

		UserResource userResource = UserResource.builder()
				.email("mrkounga@faketest.com")
				.firstName("michel")
				.surname("kounga")
				.build();
		return userResource;
	}

	@Override
	protected <D extends IDto> D givenDto() {

		UserDto userDto = UserDto.builder()
				.email("mrkounga@faketest.com")
				.firstName("michel")
				.surname("kounga")
				.build();
		return (D) userDto;
	}

}
