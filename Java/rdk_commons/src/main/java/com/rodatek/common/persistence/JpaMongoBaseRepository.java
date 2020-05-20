package com.rodatek.common.persistence;

import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.base.model.entity.JpaMongoBaseEntity;

//still under poc
@NoRepositoryBean
public interface JpaMongoBaseRepository<T extends JpaMongoBaseEntity>  extends BaseJpaRepository<T>, BaseMongoRepository<T>{

}
