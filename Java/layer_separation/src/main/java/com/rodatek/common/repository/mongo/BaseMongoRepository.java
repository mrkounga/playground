package com.rodatek.common.repository.mongo;

import java.util.Optional;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.BaseRepository;



@NoRepositoryBean
public interface BaseMongoRepository<E extends IEntity> extends BaseRepository<E> { //extends MongoRepository<M,Long>, BaseRepository<M>{ 
	E save(E entity);
	Optional<E> findById(Long id);
	void deleteById(Long id);
}
