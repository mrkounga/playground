package com.rodatek.common.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.PersistenceService;

@SpringBootTest
@SpringJUnitConfig()
@DisplayName(value = "Test - Common Persistence Service")
public abstract class Test_AbstractPersitenceService<D extends IDto> { 
	
	protected abstract D givenDto();

	protected abstract List<D> givenListDtos();

	protected abstract void testUpdate();
	
	//test case
	protected abstract void testConvertEntityToDto();
	
	//test case
	protected abstract  void testConvertDtoToEntity();
	
	protected abstract PersistenceService<D>  getPersistenceService();
	

	@Test
	@DisplayName("Test - Peristence Service Not Null")
	void testAbstractPersistenceService() {
		assertThat(getPersistenceService()).isNotNull();
	}

	@Test
	@DisplayName("Test - Peristence Service : Delete All")
	void testDeleteAll() {
		// arrange
		D savedDto = getPersistenceService().create(givenDto());

		// act
		getPersistenceService().deleteAll();

		// assert
		assertThat(savedDto.getId()).isNotNull();
		assertThat(getPersistenceService().count()).isEqualTo(0);

	}

	@Test
	@DisplayName("Test -  Peristence Service : Find All")
	void testFindAll() {
		getPersistenceService().findAll();
	}

	@Test
	@DisplayName("Test - Peristence Service : Create New dto")
	// @Order(value = 1)
	void testCreate() {

		// Arrange
		D newDto = givenDto();

		// Act
		D createdDto = getPersistenceService().create(newDto);
		
		// Assert
		assertThat(newDto.getId()).isNull();
		assertThat(createdDto.getId()).isNotNull();

	}

	@Test
	@DisplayName("Test -  Peristence Service : Find by Id")
	void testFindById() {
		// arrange

		String id = getPersistenceService().create(givenDto()).getId();

		// act
		D foundById = getPersistenceService().findById(id).get();

		// assert
		assertThat(id).isEqualTo(foundById.getId());

	}

	@Test
	@DisplayName("Test - Peristence Service : Delete by ID")
	void testDeleteById() {
		// Arrange
		String id = getPersistenceService().create(givenDto()).getId();

		// Act
		getPersistenceService().deleteById(id);

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			getPersistenceService().findById(id);
		});

	}

	@Test
	@DisplayName("Test - Peristence Service : Load sample test data")
	@Order(value = 1)
	void loadTestData() {
		long listSize = givenListDtos().size();

		// act
		givenListDtos().forEach(dto -> getPersistenceService().create(dto));
		long totalRecord = getPersistenceService().count();

		// assert
		assertThat(totalRecord).isGreaterThanOrEqualTo(listSize);

	}

	@Test
	@DisplayName("Test - Peristence Service : Count number of Record")
	void testCount() {
		// arrange
		List<D> dto_to_saved = givenListDtos();
		long totalDtoToSaved = givenListDtos().size();
		getPersistenceService().saveAll(dto_to_saved);

		// act
		long totalRecordCount = getPersistenceService().count();

		// assert
		assertThat(totalRecordCount).isGreaterThanOrEqualTo(totalDtoToSaved);

	}

	@Test
	@DisplayName("Test - Peristence Service : Save in Batch")
	void testSaveAll() {
		// arrange
		List<D> dto_to_saved = givenListDtos();
		List<D> dtoSaved = new ArrayList<D>();

		// act
		dtoSaved = getPersistenceService().saveAll(dto_to_saved);

		// assert
		assertThat(dtoSaved.containsAll(givenListDtos()));
	}

	@Test
	@DisplayName("Test - Peristence Service : Check if Record exist")
	void testExist() {
		// Arrange
		String id = getPersistenceService().create(givenDto()).getId();

		// act
		boolean isExist = getPersistenceService().exist(id);

		// assert
		assertThat(isExist).isEqualTo(Boolean.TRUE);
	}

}
