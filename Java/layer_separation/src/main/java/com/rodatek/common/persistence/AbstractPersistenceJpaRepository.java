package com.rodatek.common.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.model.JpaEntity;

@Service
@Qualifier("jpa")
public class AbstractPersistenceJpaRepository< E extends JpaEntity> implements PersistenceService<E> {

	protected BaseJpaRepository<E> repository;
	
	public AbstractPersistenceJpaRepository(BaseJpaRepository<E> repository) {
		this.repository = repository;
	}
	
	public E SaveEntity(E entity) {
		return repository.save(entity);	
	}

	public Optional<E> findEntityById(Long id) {		
		return repository.findById(id);
	}

}
