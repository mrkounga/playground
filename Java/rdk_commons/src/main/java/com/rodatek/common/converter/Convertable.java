/**
 * 
 */
package com.rodatek.common.converter;

/**
 * @author koungam
 *
 */
public interface Convertable<A,B> {
	A convertToObjectAbove(B objectBelow );
	B convertToObjectBelow(A objectAbove );
}
