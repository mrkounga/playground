package com.rodatek.common.persistence.mongo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.persistence.PersistenceService;

//@Service
//@Qualifier("mongo")
public class AbstractMongoEntityPersistenceService<E extends MongoEntity> implements PersistenceService<E>{
	
	protected BaseMongoRepository<E> repository;
	
	public AbstractMongoEntityPersistenceService(BaseMongoRepository<E> repository) {
		this.repository = repository;
	}

	public E SaveEntity(E entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<E> findEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
