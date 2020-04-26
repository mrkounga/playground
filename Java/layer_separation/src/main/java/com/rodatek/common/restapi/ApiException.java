package com.rodatek.common.restapi;

public class ApiException extends Exception{
	private static final long serialVersionUID = -4208627179618963401L;
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}