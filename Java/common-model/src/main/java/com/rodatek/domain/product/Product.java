package com.rodatek.domain.product;

import com.rodatek.domain.common.Descrable;
import com.rodatek.domain.common.Namable;

public interface Product extends Namable, Descrable{
	Float getPrice();
	String getMake();
	String getContainer();
}
