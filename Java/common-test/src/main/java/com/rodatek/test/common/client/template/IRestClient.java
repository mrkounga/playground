package com.rodatek.test.common.client.template;


import com.jayway.restassured.specification.RequestSpecification;
import com.rodatek.client.marshall.IMarshaller;
import com.rodatek.client.template.IRestClientWithUri;
import com.rodatek.common.interfaces.IDto;
import com.rodatek.common.interfaces.IOperations;

public interface IRestClient<T extends IDto> extends IOperations<T>, IRestClientAsResponse<T>, IRestClientWithUri<T> {

    // template

    RequestSpecification givenReadAuthenticated();

    RequestSpecification givenDeleteAuthenticated();

    IMarshaller getMarshaller();

    String getUri();

}
