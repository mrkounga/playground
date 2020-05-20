package com.rodatek.common.web;


import com.rodatek.common.interfaces.IDto;
import com.rodatek.common.persistence.model.IEntity;

public interface IUriMapper {

    //<T extends IEntity> String getUriBase(final Class<T> clazz);
	 <T extends IDto> String getUriBase(final Class<T> clazz);

}
