package com.rodatek.common.persistence.service;

import com.rodatek.common.interfaces.IByNameApi;
import com.rodatek.common.interfaces.INameableDto;
import com.rodatek.common.persistence.model.INameableEntity;

public interface IService2<D extends INameableDto, E extends INameableEntity> extends IRawService2<D>, IByNameApi<D> {

	

}
