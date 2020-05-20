/**
 * 
 */
package com.rodatek.common.converter.layer;

/**
 * @author koungam
 *
 */
public interface Convertable <B extends BelowLayer, U extends UpperLayer> {	
	U convertToLayerUpObject(B b);
	B convertToLayerBelowObject(U u);
	
}
