package com.rodatek.example.businessdomain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.rodatek.example.businessdomain.common.Test_AbstractCommonBusinessCrudOperation;


@DisplayName(value = "Test - User Business Service")
class UserBusinessServiceTest extends Test_AbstractCommonBusinessCrudOperation<UserDto> {
	
	protected UserDto givenDto() {
		UserDto userDto = UserDto.builder().email("mrkounga@gmail.com").firstName("Michel").surname("Kounga")
				.username("TheKoung").build();
		return userDto;
	}


	@Test
	@DisplayName("Test - Business Service : Update")
	@Override
	protected void testUpdateDto() {
		UserDto createdUser = businessService.createDto(givenDto());
		UserDto userToUpdate=null;
		userToUpdate = UserDto.builder()
				.email("myNewEmail@Corona.finimoi")
				.firstName("MK")
				.username("theKoung")
				.surname("Serge")
				.id(createdUser.getId())
				.build();
		
		userToUpdate=businessService.updateDto(userToUpdate);
	}

	

}
