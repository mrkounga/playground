package com.rodatek.common.business.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.TransactionScoped;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.persistence.PersistenceService;
import com.rodatek.common.persistence.mongo.Test_AbstractDtoMongoEntityPersistenceService;
import com.sun.org.apache.xpath.internal.operations.Bool;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@SpringJUnitConfig()
@DisplayName(value = "Test - Abstract Service")
@Log4j2
public abstract class Test_AbstractBusinessService<D extends IDto> {

	protected abstract BusinessService<D> getService();

	protected abstract D givenDto();

	protected abstract List<D> givenListDtos();

	protected abstract void testUpdate();

	@Test
	@DisplayName("Test -  Service Not Null")
	void testAbstractBusinessService() {
		assertThat(getService()).isNotNull();
	}

	@Test
	@DisplayName("Test -  Service : Delete All")
	void testDeleteAll() {
		// arrange
		D savedDto = getService().create(givenDto());

		// act
		getService().deleteAll();

		// assert
		assertThat(savedDto.getId()).isNotNull();
		assertThat(getService().count()).isEqualTo(0);

	}

	@Test
	@DisplayName("Test -  Service : Find All")
	void testFindAll() {
		getService().findAll();
	}

	@Test
	@DisplayName("Test -  Service : Create New dto")
	// @Order(value = 1)
	void testCreate() {

		// Arrange
		D newDto = givenDto();

		// Act
		D createdDto = getService().create(newDto);
		log.info(">>>>>>>>>>>>> Saved dto : " + createdDto);
		// Assert
		assertThat(newDto.getId()).isNull();
		assertThat(createdDto.getId()).isNotNull();

	}

	@Test
	@DisplayName("Test -  Service : Find by Id")
	void testFindById() {
		// arrange

		String id = getService().create(givenDto()).getId();

		// act
		D foundById = getService().findById(id).get();

		// assert
		assertThat(id).isEqualTo(foundById.getId());

	}

	@Test
	@DisplayName("Test -  Service : Delete by ID")
	void testDeleteById() {
		// Arrange
		String id = getService().create(givenDto()).getId();

		// Act
		getService().deleteById(id);

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			getService().findById(id);
		});

	}

	@Test
	@DisplayName("Test -  Service : Load sample test data")
	@Order(value = 1)
	void loadTestData() {
		long listSize = givenListDtos().size();

		// act
		givenListDtos().forEach(dto -> getService().create(dto));
		long totalRecord = getService().count();

		// assert
		assertThat(totalRecord).isGreaterThanOrEqualTo(listSize);

	}

	@Test
	@DisplayName("Test -  Service : Count number of Record")
	void testCount() {
		// arrange
		List<D> dto_to_saved = givenListDtos();
		long totalDtoToSaved = givenListDtos().size();
		getService().saveAll(dto_to_saved);

		// act
		long totalRecordCount = getService().count();

		// assert
		assertThat(totalRecordCount).isGreaterThanOrEqualTo(totalDtoToSaved);

	}

	@Test
	@DisplayName("Test -  Service : Save in Batch")
	void testSaveAll() {
		// arrange
		List<D> dto_to_saved = givenListDtos();
		List<D> dtoSaved = new ArrayList<D>();

		// act
		dtoSaved = getService().saveAll(dto_to_saved);

		// assert
		assertThat(dtoSaved.containsAll(givenListDtos()));
	}

	@Test
	@DisplayName("Test -  Service : Check if Record exist")
	void testExist() {
		// Arrange
		String id = getService().create(givenDto()).getId();

		// act
		boolean isExist = getService().exist(id);

		// assert
		assertThat(isExist).isEqualTo(Boolean.TRUE);
	}

}
