package com.rodatek.example.model;

import org.immutables.value.Value;

import com.rodatek.common.model.IEntity;
import com.rodatek.domain.user.User;

@Value.Immutable
public interface UserEntity extends User, IEntity {

}
