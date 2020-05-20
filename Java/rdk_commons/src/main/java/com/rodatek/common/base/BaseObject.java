package com.rodatek.common.base;

import java.io.Serializable;



public interface BaseObject {	
	Serializable getId();
	String getName();
	String getDescription();
    boolean isValid();
	
}
