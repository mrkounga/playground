/**
 * 
 */
package com.rodatek.poc.repository.jpacommon;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.persistence.jpa.BaseJpaRepository;
import com.rodatek.common.persistence.jpa.JpaEntity;

/**
 * @author koungam
 *
 */
@SpringJUnitConfig
@DataJpaTest
public abstract class Test_AbstractJpaRepository<E extends JpaEntity> {

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

	@Test
	public void givenAndEntitymanager_WhenAutorired_ThenItshouldntbeNull() {
		// Arrange

		// Act

		// Assert
		assertThat(entityManager).isNotNull();
	}

	// Create

	@Test
	public void testCreate() {
		// arrange
		E newEntity = createEntity();

		// act
		E persistedEntity = getRepository().save(newEntity);

		// assert
		assertThat(persistedEntity.getId()).isNotNull();
	}

	// Read

	@Test
	public void testGetOne() {
		// Arrange
		E createdEntity = getRepository().save(createEntity());

		// Act
		Optional<E> foundById = getRepository().findById(createdEntity.getId());

		// Assert
		assertThat(foundById.get()).isEqualTo(createdEntity);
	}

	@Test
	public void testUpdate() {
		// Arrange

		E createdEntity = getRepository().save(createEntity());
		Optional<E> foundById = getRepository().findById(createdEntity.getId());

		// Act
		//E entityToUpdate = foundById

		// Assert
		assertThat(foundById.get()).isEqualTo(createdEntity);
	}

	// Count

	@Test
	public void testCount() {
		// Arrange
		long entityCount = createListEntities().size();
		 List<E> entitiesFound=getRepository().saveAll(createListEntities());

		// Act
	
		 long entityFoundCount=entitiesFound.size();

		// Assert
		 assertThat(entityCount).isEqualTo(entityFoundCount);
	}

	// Find all

	@Test
	public void testFindAll() {
		// Arrange
		List<E> entitiesFound=getRepository().saveAll(createListEntities());

		// Act
		List<E> entities = getRepository().findAll();

		// Assert
		assertThat(entities).isNotEmpty();
	}

	public void testFindAllSort() {
		// Arrange

		// Act

		// Assert
	}

	public void testFindAllByIdIterableOfID() {
		// Arrange

		// Act

		// Assert
	}

	public void testSaveAllIterableOfS() {
		// Arrange

		// Act

		// Assert
	}

	public void testFlush() {
		// Arrange

		// Act

		// Assert
	}

	public void testSaveAndFlush() {
		// Arrange

		// Act

		// Assert
	}

	public void testDeleteInBatch() {
		// Arrange

		// Act

		// Assert
	}

	public void testDeleteAllInBatch() {
		// Arrange

		// Act

		// Assert
	}

	public void testFindAllExampleOfS() {
		// Arrange

		// Act

		// Assert
	}

	public void testFindAllExampleOfSSort() {
		// Arrange

		// Act

		// Assert
	}

	public void testFindAllSort1() {
		// Arrange

		// Act

		// Assert
	}

	public void testFindAllPageable() {
		// Arrange

		// Act

		// Assert
	}

}