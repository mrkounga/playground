package com.rodatek.common.persistence;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.base.model.entity.BaseMongoEntity;


/**
 * @author koungam
 *
 */

@NoRepositoryBean
public interface BaseMongoRepository<E extends BaseMongoEntity> extends  BaseRepository<E> {//MongoRepository<E, Serializable>, {

}
