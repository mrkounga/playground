/**
 * 
 */
package com.rodatek.example.repository.jpacommon;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.jpa.BaseJpaRepository;

/**
 * @author koungam
 *
 */

@DataJpaTest
public abstract class Test_AbstractJpaRepository<E extends IEntity> {

	@Autowired
	protected TestEntityManager entityManager;

	protected abstract BaseJpaRepository<E> getRepository();

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
	@DisplayName("Test - Entity Manager Not Null")
	public void givenAndEntitymanager_WhenAutorired_ThenItshouldntbeNull() {
		// Arrange

		// Act

		// Assert
		assertThat(entityManager).isNotNull();
	}

	// Create

	@Test
	@DisplayName("Test - Entity Creation...")
	public void testCreate() {
		// act
		E persistedEntity = getRepository().save(createEntity());
		
		// assert
		assertThat(entityManager.getId(persistedEntity)).isNotNull();
	}

	// Read

	@Test
	@DisplayName("Test - Find Entity By Id")
	public void testGetOne() {
		// Arrange
		E createdEntity = entityManager.persist(createEntity());

		// Act
		Optional<E> foundById = getRepository().findById(createdEntity.getId());

		// Assert
		assertThat(foundById.get()).isEqualTo(createdEntity);
	}

	
	// Count
	@Test
	@DisplayName("Test - Count Entities")
	public void testCount() {
		// Arrange
		long entityCount = createListEntities().size();
		createListEntities().forEach(e ->entityManager.persist(e));
		
		// Act		
		 long entityFoundCount=getRepository().count();

		// Assert
		 assertThat(entityCount).isEqualTo(entityFoundCount);
	}

	// Find all
	@Test
	@DisplayName("Test - Find All Entities")
	public void testFindAll() {
		//arrange
		createListEntities().forEach(e ->entityManager.persist(e));
		
		// Act		
		List<E> entities = getRepository().findAll();

		// Assert
		assertThat(entities.containsAll(createListEntities()));
	}

	@Test
	@DisplayName("Test - Find All Sort")
	public void testFindAllSort() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	@DisplayName("Test - Find All By Id Iterable of ID")
	public void testFindAllByIdIterableOfID() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	@DisplayName("Test - Save All  Iterable")
	public void testSaveAllIterableOfS() {
		// Arrange

		// Act

		// Assert
	}

	@Test
	@DisplayName("Test - Flush Entity")
	public void testFlush() {
		// Arrange
		E createdEntity = entityManager.persist(createEntity());
		// Act
		getRepository().flush();
		
		// Assert
		assertThat(createdEntity.getId()).isGreaterThan(0);
		
	}

	@Test
	@DisplayName("Test - Save And Flush")
	public void testSaveAndFlush() {
		// Arrange

		// Act
		E createdEntity =getRepository().saveAndFlush(createEntity());
		
		// Assert
		assertThat(createdEntity.getId()).isGreaterThan(0);		
	}

	@Test
	@DisplayName("Test - Delete List of Entities In Batch")
	public void testDeleteInBatch() {
		// Arrange
		createListEntities().forEach(e ->entityManager.persist(e));
		int toIndex=createListEntities().size();
		int fromIndex = toIndex/2;
		List<E> foundEntities = getRepository().findAll().subList(fromIndex, toIndex);
		int counFoundEntities=foundEntities.size();
		int entityLeft=toIndex-counFoundEntities;
		
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
		E createdEntity = entityManager.persist(createEntity());
		
		// Act
		long found_id=createdEntity.getId();
		getRepository().deleteById(found_id);

		// Assert
		assertThat(getRepository().existsById(found_id)).isFalse();
	}


	@Test
	@DisplayName("Test - Delete All In Batch")
	public void testDeleteAllInBatch() {
		// Arrange
		createListEntities().forEach(e ->entityManager.persist(e));

		// Act
		getRepository().deleteAllInBatch();

		// Assert
		assertThat(getRepository().count()).isEqualTo(0);
	}


	@Test
	@DisplayName("Test - Find All Pageable")
	public void testFindAllPageable() {
		// Arrange

		// Act

		// Assert
	}

}