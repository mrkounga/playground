package com.rodatek.example.user.repository;


import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.BaseRepository;


public abstract class Test_AbsractRepository <E extends IEntity>{
	
	protected BaseRepository<E> repository;

}
