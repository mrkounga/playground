package com.rodatek.poc.persistence;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.rodatek.common.persistence.BaseJpaRepository;
import com.rodatek.poc.model.UserEntity;


@Repository
@Primary
public interface UserJpaRepository  extends BaseJpaRepository<UserEntity> {

}
