package com.rodatek.common.persistence;

import java.util.Optional;

import com.rodatek.common.model.IEntity;

public interface PersistenceOperation<E extends IEntity> {
	E SaveEntity(E entity);
	Optional<E> findEntityById(Long id);

}
