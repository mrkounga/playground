/**
 * 
 */
package com.rodatek.example.repository.mybatiscommon;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.model.SqlEntity;
import com.rodatek.common.repository.mybatis.BaseMyBatisRepository;
import com.rodatek.common.repository.mybatis.config.PersistenceConfig;
import com.rodatek.poc.example.repository.mybatis.UserEntity;

import lombok.extern.log4j.Log4j2;

/**
 * @author koungam
 *
 */

@ContextConfiguration(classes = PersistenceConfig.class)
@SpringJUnitConfig
@DisplayName("Test - MyBatis Repository Test")
@Log4j2
public abstract class Test_AbstractMyBatisRepository<E extends SqlEntity> {

	protected abstract BaseMyBatisRepository<E> getRepository();

	protected List<E> createListEntities() {
		List<E> entities = new ArrayList<E>();
		for (int i = 0; i < 10; i++) {
			entities.add(givenEntity());
		}
		return entities;
	}

	protected abstract E givenEntity();

	protected abstract void testUpdate();

	@Test
	@DisplayName("Test - Mybatis reporitory : Not null")
	void init() {
		assertThat(getRepository()).isNotNull();
	}

	// Create

	//@Test
	@DisplayName("Test - Entity Creation...")
	public void testCreate() {
		// Arrange
		E entityToCreated = givenEntity();
		boolean isSaved;

		// act
		//isSaved = getRepository().save(entityToCreated);
		
		
		// assert
		//assertThat(isSaved).isEqualTo(Boolean.TRUE);
		
		
		//createListEntities().forEach(e -> getRepository().save(e).);
	}

	// Read

	@Test
	@DisplayName("Test - Find Entity By Id")
	@Order(value = 2)
	public void testGetOne() {
		// Arrange
		long entityId = 6; // last record in the db

		// Act
		Optional<E> foundById = getRepository().findById(entityId);

		// Assert
		assertThat(foundById.isPresent()).isEqualTo(Boolean.TRUE);
	}

	// Count
	@Test
	@DisplayName("Test - Count Entities")
	@Order(value = 1)
	public void testCount() {
		// Arrange
	

		// Act
		long entityFoundCount = getRepository().count();

		// Assert
		assertThat(entityFoundCount).isEqualTo(6); //number of record init with
	}

	// Find all
	@Test
	@DisplayName("Test - Find All Entities")
	public void testFindAll() {
		// arrange
		//createListEntities().forEach(e -> getRepository().save(e));

		// Act
		List<E> entities = getRepository().findAll();

		// Assert
		assertThat(entities.containsAll(createListEntities()));
	}

	
	

	@Test
	@DisplayName("Test - Delete By Id")
	@Order(value = 3)
	public void testDeleteById() {
		// Arrange
		long enityId=1L;
		
		// Act
		
		getRepository().deleteById(enityId);

		// Assert
		assertThat(getRepository().findById(enityId).isPresent()).isFalse();
	}

}