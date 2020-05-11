package com.rodatek.poc.example.repository.jpa;


import org.springframework.stereotype.Repository;

import com.rodatek.common.repository.jpa.BaseJpaRepository;

@Repository
public interface UserJpaRepository  extends BaseJpaRepository<UserJpaEntity> {

}
