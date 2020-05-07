package com.rodatek.example.persitenceservice.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.persistence.PersistenceService;

@SpringBootTest
@SpringJUnitConfig()
@DisplayName(value = "Test - Persistence Service")
public abstract class Test_AbstractPersistenceService<D extends IDto> {
	
	protected abstract PersistenceService<D> getPeristenceService();
	
	protected abstract D givenDto();
	
	protected abstract < E extends IEntity> E givenEntity();
	
	protected abstract void testConvertToLayerObjectUp();
	
	protected abstract void testConvertToLayerObjectDown();
	protected abstract void  testUpdate();
	
	
	@Test
	@DisplayName("Test - Persistence Service : Create New Entity")
	void testCreate() {
		
		// Arrange
		D newDto = givenDto();
		
		// Act
		D createdDto = getPeristenceService().create(newDto);

		// Assert
		assertThat(newDto.getId()).isNull();
		assertThat(createdDto.getId()).isGreaterThan(0);

	}

	@Test
	@DisplayName("Test - Persistence Service : Find Entity ById")
	void testFindEntityById() {
		// Arrange
		D createdDto = getPeristenceService().create(givenDto());
		D dtoFoundById = null;
		
		// Act
		dtoFoundById = getPeristenceService().findById(createdDto.getId()).get();

		// Assert
		assertThat(createdDto.getId()).isEqualTo(dtoFoundById.getId());
	}

	
	@Test
	@DisplayName("Test - Persistence Service : Delete Entity")
	void testDelete() {
		// Arrange
		D createdDto = getPeristenceService().create(givenDto());

		// Act
		getPeristenceService().delete(createdDto.getId());

		// Assert
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			getPeristenceService().findById(createdDto.getId());
		});
	}
	
	

}
