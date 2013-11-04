package com.Chat.Util;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * 暗号化、復号化クラス
 * User: miyamoto_s
 * Date: 2013/10/20
 * Time: 2:11
 */
public class CryptUtil {

    /**
     * 秘密鍵
     */
    private final static String SECRET_KEY = "W#k,97H.2]`/-<@lWA6}$YfS?%QB-&iF";
    /**
     * 鍵
     */
    private static SecretKeySpec key;

    /**
     * コンストラクタ
     */
    static {

        byte[] bytes = new byte[128 / 8];
        byte[] keys = null;

        try {
            keys = SECRET_KEY.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < SECRET_KEY.length(); i++) {
            if (i >= bytes.length)
                break;
            bytes[i] = keys[i];
        }
        key = new SecretKeySpec(bytes, "AES");
    }

    /**
     * 暗号化する
     *
     * @return 暗号化文字列
     */
    public static String encrypt(String targetStr) {
        String en = targetStr;
        byte[] de = null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            de = cipher.doFinal(en.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.encode(de);
    }

    /**
     * 復号化
     *
     * @param targetStr
     * @return
     */
    public static String decrypt(String targetStr) {
        String de = targetStr;
        byte[] en = null;
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            en = cipher.doFinal(Base64.decode(de));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(en);
    }
}


