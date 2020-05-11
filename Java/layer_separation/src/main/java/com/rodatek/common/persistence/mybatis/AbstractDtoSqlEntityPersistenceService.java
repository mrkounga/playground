package com.rodatek.common.persistence.mybatis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rodatek.common.business.domain.IDto;
import com.rodatek.common.model.SqlEntity;
import com.rodatek.common.repository.mybatis.BaseMyBatisRepository;


public abstract class AbstractDtoSqlEntityPersistenceService<D extends IDto, E extends SqlEntity> implements PersistenceSqlEntityService<D,E> {
	
	protected  BaseMyBatisRepository<E> repository;
	
	public AbstractDtoSqlEntityPersistenceService( BaseMyBatisRepository<E> repository) {
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
	public void deleteById(String id) {
		// Persistence service : precondition check to be implemented
		repository.deleteById(Long.parseLong(id));
	}
	
	@Override
	public List<D> findAll() {
		List<D> dtos = new ArrayList<D>();
		repository.findAll().forEach(e -> dtos.add(convertEntityToDto(e)));
		return dtos;
	}
	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override 
	public D create(D dto) {
		//Persistence service : precondition check  to be implemented
		//boolean isCreated=repository.save(convertDtoToEntity(dto));
		return null; // Work in progress
		//return  convertEntityToDto(repository.save(convertDtoToEntity(dto))); 
	}

	@Override
	public Optional<D> findById(String id) {
		//Persistence service :   precondition check to be implemented
		return Optional.of(convertEntityToDto(repository.findById(Long.parseLong(id)).get()));
		
	}

	@Override
	public D update(D dto) {
		// Persistence service : precondition check  to be implemented
		//boolean isUpdated=repository.save(convertDtoToEntity(dto));
		return null;// Work in progress
		//return convertEntityToDto(repository.save(convertDtoToEntity(dto))); 
	}
	//to be implemented
	@Override
	public long count() { //to be implemented
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<D> saveAll(List<D> dtos) { //to be implemented
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean exist(String id) { //to be implemented
		// TODO Auto-generated method stub
		return false;
	}

}
