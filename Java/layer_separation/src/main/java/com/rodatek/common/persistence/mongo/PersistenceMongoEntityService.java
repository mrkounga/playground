package com.rodatek.common.persistence.mongo;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.MongoEntity;
import com.rodatek.common.persistence.PersistenceService;

public interface PersistenceMongoEntityService<D extends IDto, E extends MongoEntity> extends PersistenceService<D> {
	D convertEntityToDto(E entity);

	E convertDtoToEntity(D dto);

}
