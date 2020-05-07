package com.rodatek.common.persistence;


import com.rodatek.common.business.domain.IDto;



public interface PersistenceService<D extends IDto> extends PersistenceOperation<D> {

}
