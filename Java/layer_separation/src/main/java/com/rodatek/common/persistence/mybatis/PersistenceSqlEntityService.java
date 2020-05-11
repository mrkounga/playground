package com.rodatek.common.persistence.mybatis;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.SqlEntity;
import com.rodatek.common.persistence.PersistenceService;

public interface PersistenceSqlEntityService<D extends IDto, E extends SqlEntity> extends PersistenceService<D> {
	D convertEntityToDto(E entity);

	E convertDtoToEntity(D dto);


}
