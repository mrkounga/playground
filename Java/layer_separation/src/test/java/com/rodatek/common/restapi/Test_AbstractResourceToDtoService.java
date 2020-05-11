package com.rodatek.common.restapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

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

@SpringBootTest
@SpringJUnitConfig()
@DisplayName(value = "Test - Resource Service")
public abstract class Test_AbstractResourceToDtoService<R extends IResource, D extends IDto> {

	protected abstract ReourceDtoControllerService<R, D> getControllerService();

	protected abstract R givenResource();

	protected abstract List<R> givenListResources();

	// Test
	protected abstract void testUpdateResource();

	@Test
	@DisplayName("Test - ResourceDtoService : Not null")
	void testAbstractResourceToDtoService() {
		assertThat(getControllerService()).isNotNull();
	}

	@Test
	@DisplayName("Test - Resource Service : resource creation")
	void testCreateResource() {
		// Arrange
		R newRo = givenResource();

		// Act
		R createdRo = getControllerService().createResource(newRo);

		// Assert
		assertThat(newRo.getId()).isNull();
		assertThat(createdRo.getId()).isNotNull();
	}

	@Test
	@DisplayName("Test - Resource Service : Find by Id")
	void testFindRessourceById() {
		// arrange

		String id = getControllerService().createResource(givenResource()).getId();

		// act
		R foundById = getControllerService().findRessourceById(id).get();

		// assert
		assertThat(id).isEqualTo(foundById.getId());
	}

	@Test
	@DisplayName("Test - Resource Service : Delete by ID")
	void testDeleteResourceById() {
		// Arrange
		String id = getControllerService().createResource(givenResource()).getId();

		// Act
		getControllerService().deleteResourceById(id);

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			getControllerService().findRessourceById(id);
		});
	}

	@Test
	@DisplayName("Test -  Reource Service : Find All")
	void testFindAllResource() {
		getControllerService().findAllResource();
	}

	@Test
	@DisplayName("Test - Resource Service : Delete All")
	void testDeleteAllResource() {
		// arrange
		R savedResources = getControllerService().createResource(givenResource());

		// act
		getControllerService().deleteAllResource();

		// assert
		assertThat(savedResources.getId()).isNotNull();
		assertThat(getControllerService().count()).isEqualTo(0);
	}

	@Test
	@DisplayName("Test -  Resourcce Service : Load sample test data")
	@Order(value = 1)
	void loadTestData() {
		long listSize = givenListResources().size();

		// act
		givenListResources().forEach(dto -> getControllerService().createResource(dto));
		long totalRecord = getControllerService().count();

		// assert
		assertThat(totalRecord).isGreaterThanOrEqualTo(listSize);

	}

	@Test
	@DisplayName("Test - Resource Service : Count number of Record")
	void testCount() {
		// arrange
		List<R> resource_to_saved = givenListResources();
		long totalResourcesToSaved = givenListResources().size();
		getControllerService().saveAllResource(resource_to_saved);

		// act
		long totalRecordCount = getControllerService().count();

		// assert
		assertThat(totalRecordCount).isGreaterThanOrEqualTo(totalResourcesToSaved);
	}

	@Test
	@DisplayName("Test -  Resource Service : Save in Batch")
	void testSaveAllResource() {
		// arrange
		List<R> reources_to_saved = givenListResources();
		List<R> resourceSaved = new ArrayList<R>();

		// act
		resourceSaved = getControllerService().saveAllResource(reources_to_saved);

		// assert
		assertThat(resourceSaved.containsAll(reources_to_saved));
	}

	@Test
	@DisplayName("Test -  ResourceService : Check if Record exist")
	void testExist() {
		// Arrange
		String id = getControllerService().createResource(givenResource()).getId();

		// act
		boolean isExist = getControllerService().exist(id);

		// assert
		assertThat(isExist).isEqualTo(Boolean.TRUE);
	}

	@Test
	@DisplayName("Test - Persitence Service : Dto to Resource conversion")
	protected void convertDtoToResource() {
		// arrange
		D persisteDto = getControllerService()
				.convertResourceToDto(getControllerService().createResource(givenResource()));

		// act
		R resourceConverted = getControllerService().convertDtoToResource(persisteDto);

		// assert
		assertThat(persisteDto.getId()).isEqualTo(resourceConverted.getId());
	}

	@Test
	@DisplayName("Test - Resource Service : Resource to Dto conversion")
	protected void convertResourceToDto() {
		// arrange & act
		D convertedDto = getControllerService().convertResourceToDto(givenResource());

		// assert
		assertThat(convertedDto.getId()).isEqualTo(givenResource().getId());

	}

}
