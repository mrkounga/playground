package com.rodatek.poc.example.repository.jpa;


import org.springframework.stereotype.Repository;

import com.rodatek.common.repository.jpa.BaseJpaRepository;
import com.rodatek.poc.example.model.UserEntity;

@Repository
public interface UserJpaRepository  extends BaseJpaRepository<UserEntity> {

}
