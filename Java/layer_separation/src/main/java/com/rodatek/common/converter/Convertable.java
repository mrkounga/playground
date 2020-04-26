package com.rodatek.common.converter;

public interface Convertable<UP, DOWN> {
	UP convertToLayerObjectUp(DOWN resourceToConvert);
	DOWN convertToLayerObjectDown(UP resourceToConvert);
}
