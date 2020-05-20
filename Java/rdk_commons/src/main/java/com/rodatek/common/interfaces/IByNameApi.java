package com.rodatek.common.interfaces;

public interface IByNameApi<T extends IWithName> {

    T findByName(final String name);

}
