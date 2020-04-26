package com.rodatek.common.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rodatek.common.model.MongoEntity;


@Service
@Qualifier("mybatis")
public class AbstractPersistenceMapper <E extends MongoEntity> implements PersistenceService<E> {

	public E SaveEntity(E entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<E> findEntityById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
