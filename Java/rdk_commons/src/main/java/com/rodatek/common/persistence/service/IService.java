package com.rodatek.common.persistence.service;

import com.rodatek.common.interfaces.IByNameApi;
import com.rodatek.common.interfaces.IWithName;

public interface IService<T extends IWithName> extends IRawService<T>, IByNameApi<T> {

    //

}
