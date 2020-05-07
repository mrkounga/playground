package com.rodatek.example.user.repository;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rodatek.common.model.IEntity;
import com.rodatek.common.repository.BaseRepository;

@DataJpaTest
public abstract class Test_AbsractRepository <E extends IEntity>{
	
	protected BaseRepository<E> repository;

}
