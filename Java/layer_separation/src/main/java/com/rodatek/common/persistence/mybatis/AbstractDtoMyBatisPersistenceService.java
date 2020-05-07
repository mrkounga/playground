package com.rodatek.common.persistence.mybatis;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.IEntity;
import com.rodatek.common.model.SqlEntity;
import com.rodatek.common.repository.mybatis.BaseMyBatisRepository;
import com.rodatek.common.persistence.AbstractDtoEntityPersistenceService;
import com.rodatek.common.persistence.PersistenceService;


//@Service
//@Qualifier("myBatis")
public abstract class AbstractDtoMyBatisPersistenceService<D extends IDto, E extends IEntity> extends AbstractDtoEntityPersistenceService<D,E> {
	
	protected  BaseMyBatisRepository<E> repository;
	
	public AbstractDtoMyBatisPersistenceService( BaseMyBatisRepository<E> repository) {
		super(repository);
		this.repository=repository;
	}


	/*
	 * public D createDto(D dto) { return
	 * convertToLayerObjectUp(repository.save(convertToLayerObjectDown(dto))); }
	 * 
	 * public Optional<D> getDtoById(Long id) { return
	 * Optional.of(convertToLayerObjectUp(repository.findById(id).get())); }
	 */
	

	@Override
	public void delete(Long id) {
		// Persistence service : precondition check to be implemented
		repository.deleteById(id);
	}

	@Override
	public D create(D dto) {
		//Persistence service : precondition check  to be implemented
		return  convertEntityToDto(repository.save(convertDtoToEntity(dto))); 
	}

	@Override
	public Optional<D> findById(Long id) {
		//Persistence service :   precondition check to be implemented
		return Optional.of(convertEntityToDto(repository.findById(id).get()));
		
	}

	@Override
	public D update(D dto) {
		// Persistence service : precondition check  to be implemented
		return convertEntityToDto(repository.save(convertDtoToEntity(dto))); 
	}

}
