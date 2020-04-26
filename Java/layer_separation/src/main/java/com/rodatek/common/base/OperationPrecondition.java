package com.rodatek.common.base;

public interface OperationPrecondition<B extends BaseObject> {
	boolean isValid(B b);
	boolean isNotNull(B b);
}
