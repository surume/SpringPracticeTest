package com.Chat.Model.Util;

/**
 * StringUtil
 * User: miyamoto_s
 * Date: 2013/10/19
 * Time: 2:09
 */
public class StringUtil {

    /**
     * 指定された String が null または空文字列かどうかを返します。
     *
     * @param value チェックする String
     * @return null または空文字列かどうか。null または空文字列なら true 、それ以外なら false 。
     */
    public static boolean isEmpty(String value) {
        if (value == null || value.length() == 0)
            return true;
        else
            return false;
    }
}
