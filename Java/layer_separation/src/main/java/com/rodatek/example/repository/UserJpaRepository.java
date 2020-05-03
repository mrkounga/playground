package com.rodatek.example.repository;


import org.springframework.stereotype.Repository;

import com.rodatek.common.persistence.jpa.BaseJpaRepository;
import com.rodatek.example.model.impl.UserJpaEntity;

@Repository
public interface UserJpaRepository  extends BaseJpaRepository<UserJpaEntity> {

}
