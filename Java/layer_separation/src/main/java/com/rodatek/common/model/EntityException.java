package com.rodatek.common.model;

public class EntityException extends Exception {
	private static final long serialVersionUID = 2811135034559497164L;
	private int code;

	public EntityException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}