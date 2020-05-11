package com.rodatek.common.persistence.jpa;

import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.JpaEntity;
import com.rodatek.common.persistence.PersistenceService;

public interface PersistenceJpaEntityService<D extends IDto, E extends JpaEntity> extends PersistenceService<D> {
	D convertEntityToDto(E entity);

	E convertDtoToEntity(D dto);

}
