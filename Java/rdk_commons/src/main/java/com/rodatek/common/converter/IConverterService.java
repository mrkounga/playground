/**
 * 
 */
package com.rodatek.common.converter;

import com.rodatek.common.base.BaseObject;

/**
 * @author koungam
 *
 */
public interface IConverterService<A extends BaseObject, B extends BaseObject>
		extends Convertable<A, B> {

	A convertToObjectAbove(B objectBelow);

	B convertToObjectBelow(A objectAbove);

}
