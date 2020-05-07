package com.rodatek.common.repository.mongo;

import java.util.Optional;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.BaseRepository;

import lombok.extern.log4j.Log4j2;



@NoRepositoryBean
public interface BaseMongoRepository<E extends IEntity> extends BaseRepository<E> { //extends MongoRepository<M,Long>, BaseRepository<M>{ 
	E save(E entity);
	Optional<E> findById(Long id);
	void deleteById(Long id);
}
