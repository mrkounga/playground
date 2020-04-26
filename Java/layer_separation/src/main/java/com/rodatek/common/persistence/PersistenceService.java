package com.rodatek.common.persistence;

import com.rodatek.common.model.IEntity;

public interface PersistenceService<E extends IEntity> extends PersistenceOperation<E> {

}
