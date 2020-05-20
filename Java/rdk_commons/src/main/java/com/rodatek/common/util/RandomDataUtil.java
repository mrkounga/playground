/**
 * 
 */
package com.rodatek.common.util;


import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;


/**
 * @author koungam
 *
 */


public final class RandomDataUtil {

    private RandomDataUtil() {
        throw new AssertionError();
    }

    // API

    public static String randomEmail() {
        return randomAlphabetic(6) + "@" + randomAlphabetic(4) + ".com";
    }

}