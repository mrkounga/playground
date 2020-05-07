package com.rodatek.example.businessdomain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.poc.example.domain.UserDto;

//In progress
@SpringJUnitConfig()
public class Test_UserDto {
	
	@Test
	@DisplayName("Test - Create valid User Object")
	void createDto() {
		UserDto user = UserDto.builder().build();
		
	}

}
