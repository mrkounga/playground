package com.rodatek.client.template;

import com.rodatek.common.interfaces.IDto;

public interface IRestClientWithUri<T extends IDto> extends IReadOnlyTemplateWithUri<T> {

    // create

    String createAsUri(final T resource);

}
