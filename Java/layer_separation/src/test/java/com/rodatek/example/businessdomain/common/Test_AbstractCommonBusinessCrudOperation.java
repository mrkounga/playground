package com.rodatek.example.businessdomain.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.business.service.BusinessService;

@SpringJUnitConfig()
@SpringBootTest
@DisplayName(value = "Test - Business Service")
public abstract class Test_AbstractCommonBusinessCrudOperation<D extends IDto> {

	@Autowired
	protected BusinessService<D> businessService;

	protected abstract D givenDto();
	
	protected abstract void testUpdateDto();

	@Test
	@DisplayName("Test - Business Service : New Creation")
	void testCreate() {

		// Arrange
		D newDto = givenDto();

		// Act
		D createdDto = businessService.createDto(newDto);

		// Assert
		assertThat(newDto.getId()).isNull();
		assertThat(createdDto.getId()).isGreaterThan(0);

	}

	@Test
	@DisplayName("Test - Business Service : Find ById")
	void testFindEntityById() {
		// Arrange
		D createdDto = businessService.createDto(givenDto());
		D dtoFoundById = null;

		// Act
		dtoFoundById = businessService.findDtoById(createdDto.getId()).get();

		// Assert
		assertThat(createdDto.getId()).isEqualTo(dtoFoundById.getId());
	}

	@Test
	@DisplayName("Test - Business Service : Deletion")
	void testDelete() {
		// Arrange
		D createdDto = businessService.createDto(givenDto());

		// Act
		businessService.deleteDtoById(createdDto.getId());

		// Assert
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			businessService.findDtoById(createdDto.getId());
		});
	}

}
