package com.rodatek.common.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.model.JpaEntity;
import com.rodatek.common.repository.BaseRepository;




@NoRepositoryBean
public interface BaseJpaRepository<E extends JpaEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> , BaseRepository<E>{
	
}