package com.rodatek.common.model;

import java.util.Optional;

public interface EntityOperation<E extends IEntity> {
	E createEntity (E entity);
	Optional<E> getEntityById(Long id);

}
