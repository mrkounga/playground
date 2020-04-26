package com.rodatek.common.model;



import java.util.Optional;

import com.rodatek.common.persistence.PersistenceService;

public class AbstractEntityService<E extends IEntity> implements EntityService<E>{
	
	protected PersistenceService<E> dao;
	
	public AbstractEntityService(PersistenceService<E> repo) {
		this.dao= repo;
	}

	public E createEntity(E entity) {
		// TODO Auto-generated method stub
		return dao.SaveEntity(entity);
	}

	public Optional<E> getEntityById(Long id) {
		// TODO Auto-generated method stub
		return dao.findEntityById(id);
	}

}
