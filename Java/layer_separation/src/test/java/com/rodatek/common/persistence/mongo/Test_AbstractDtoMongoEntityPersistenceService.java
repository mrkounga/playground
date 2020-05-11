package com.rodatek.common.persistence.mongo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.MongoEntity;
import com.rodatek.common.persistence.Test_AbstractPersitenceService;


public abstract class Test_AbstractDtoMongoEntityPersistenceService<D extends IDto, E extends MongoEntity> extends Test_AbstractPersitenceService<D> {

	protected abstract PersistenceMongoEntityService<D, E> getPersistenceService();
	
	@Override
	@Test
	@DisplayName("Test - Persitence Service : Entity to Dto conversion")
	protected void testConvertEntityToDto() {
		//arrange
		E persisteEntity = getPersistenceService().convertDtoToEntity(getPersistenceService().create(givenDto()));
		
		//act
		D dtoConverted = getPersistenceService().convertEntityToDto(persisteEntity);
		
		//assert
		assertThat(persisteEntity.getId()).isEqualTo(dtoConverted.getId());
	}

	@Override
	@Test
	@DisplayName("Test - Persitence Service : Dto to Entity conversion")
	protected void testConvertDtoToEntity() {
		//arrange & act
		E convertedEntity=getPersistenceService().convertDtoToEntity(givenDto());
		
		//assert
		assertThat(convertedEntity.getId()).isEqualTo(givenDto().getId());
		
	}

	
}
