package com.rodatek.common.persistence.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.rodatek.common.persistence.BaseRepository;




@NoRepositoryBean
public interface BaseJpaRepository<E extends JpaEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> , BaseRepository<E>{
	
}