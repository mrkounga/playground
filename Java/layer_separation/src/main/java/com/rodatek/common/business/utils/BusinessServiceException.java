package com.rodatek.common.business.utils;

public class BusinessServiceException extends Exception {
	private static final long serialVersionUID = 2811135034559497164L;
	private int code;

	public BusinessServiceException(int code, String msg) {
		super(msg);
		this.code = code;
	}
}