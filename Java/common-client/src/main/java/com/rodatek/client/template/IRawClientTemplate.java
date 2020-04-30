package com.rodatek.client.template;

import org.apache.commons.lang3.tuple.Pair;

import com.rodatek.common.interfaces.IDto;
import com.rodatek.common.interfaces.IOperations;

public interface IRawClientTemplate<T extends IDto> extends IOperations<T>, IRestClientWithUri<T> {

    //

    String getUri();

    // create

    T create(final T resource, final Pair<String, String> credentials);

    T findOne(final long id, final Pair<String, String> credentials);

}
