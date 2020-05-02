package com.rodatek.common.domain;

public class BusinessException extends Exception {
	private static final long serialVersionUID = 2811135034559497164L;
	private int code;

	public BusinessException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}