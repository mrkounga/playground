package com.rodatek.example.repository.mongocommon;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.model.MongoEntity;
import com.rodatek.common.repository.mongo.BaseMongoRepository;
import com.rodatek.example.user.repository.Test_AbsractRepository;

import lombok.extern.log4j.Log4j2;

@DataMongoTest
@SpringJUnitConfig
public abstract class Test_AbtractMongoRepository<E extends MongoEntity>  {

	protected abstract BaseMongoRepository<E> getRepository();
	
	protected List<E> createListEntities() {
		List<E> entities = new ArrayList<E>();
		for (int i = 0; i < 10; i++) {
			entities.add(createEntity());
		}
		return entities;
	}

	protected abstract E createEntity();

	protected abstract void testUpdate();

	@Test
	@DisplayName("Test - Repository Not Null")
	void init() {
		assertThat(getRepository()).isNotNull();
	}

	

	// Create
	@Test
	@DisplayName("Test - Entity Creation...")
	public void testCreate() {
		E entityToCreate=createEntity();
		// act
		E persistedEntity = getRepository().save(entityToCreate);

		// assert
		assertThat(persistedEntity.getId()).isNotNull();
	}

	// Read

	@Test
	@DisplayName("Test - Find Entity By Id")
	public void testGetOne() {
		// Arrange
		E createdEntity = getRepository().save(createEntity());

		// Act
		 E foundById = getRepository().findById(createdEntity.getId()).get();

		// Assert
		assertThat(foundById).isEqualTo(createdEntity);
	}

	// Count
	@Test
	@DisplayName("Test - Count Entities")
	@Order(value = 1)
	public void testCount() {
		// Arrange
		getRepository().deleteAll();
		long entityCount = createListEntities().size();
		createListEntities().forEach(e -> getRepository().save(e));

		// Act
		long entityFoundCount = getRepository().count();

		// Assert
		assertThat(entityCount).isEqualTo(entityFoundCount);
	}

	// Find all
	@Test
	@DisplayName("Test - Find All Entities")
	public void testFindAll() {
		// arrange
		createListEntities().forEach(e -> getRepository().save(e));

		// Act
		List<E> entities = getRepository().findAll();
		entities.forEach(e->System.out.println(e.toString()));

		// Assert
		assertThat(entities.containsAll(createListEntities()));
	}

	// @Test
	@DisplayName("Test - Find All Sort")
	public void testFindAllSort() {
		// Arrange

		// Act

		// Assert
	}

	// @Test
	@DisplayName("Test - Find All By Id Iterable of ID")
	public void testFindAllByIdIterableOfID() {
		// Arrange

		// Act

		// Assert
	}

	// @Test
	@DisplayName("Test - Save All  Iterable")
	public void testSaveAllIterableOfS() {
		// Arrange

		// Act

		// Assert
	}

	
	@Test
	@DisplayName("Test - Delete List of Entities In Batch")
	public void testDeleteInBatch() {
		// Arrange
		getRepository().deleteAll();
		createListEntities().forEach(e -> getRepository().save(e));
		int toIndex = createListEntities().size();
		int fromIndex = toIndex / 2;
		List<E> foundEntities = getRepository().findAll().subList(fromIndex, toIndex);
		int counFoundEntities = foundEntities.size();
		int entityLeft = toIndex - counFoundEntities;

		// Act
		getRepository().deleteAll(foundEntities);
		int countRemainingEntity = getRepository().findAll().size();
		// Assert
		assertThat(countRemainingEntity).isEqualTo(entityLeft);

	}

	@Test
	@DisplayName("Test - Delete By Id")
	public void testDeleteById() {
		// Arrange
		E createdEntity = getRepository().save(createEntity());
	
		// Act
		String found_id = createdEntity.getId();
		getRepository().deleteById(createdEntity.getId());

		// Assert
		assertThat(getRepository().existsById(found_id)).isFalse();
	}

	

	// @Test
	@DisplayName("Test - Find All Pageable")
	public void testFindAllPageable() {
		// Arrange

		// Act

		// Assert
	}
	
	
		
		
		
	

}
