package com.rodatek.poc.repository;


import org.springframework.stereotype.Repository;

import com.rodatek.common.persistence.jpa.BaseJpaRepository;
import com.rodatek.poc.model.impl.UserJpaEntity;

@Repository
public interface UserJpaRepository  extends BaseJpaRepository<UserJpaEntity> {

}
