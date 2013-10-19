package com.Chat.Model;

import com.Chat.Util.StringUtil;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: miyamoto_s
 * Date: 2013/10/19
 * Time: 3:00
 * To change this template use File | Settings | File Templates.
 */
public class SigninFormModel {
    private String userName;
    private String email;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * NullのFieldがあるかどうかチェックする
     * @return NullのFieldがある場合はTrue
     */
    public boolean checkNullField() {

        return ( StringUtil.isEmpty(this.userName)
                || StringUtil.isEmpty(this.email)
                || StringUtil.isEmpty(this.password));
    }

    /**
     * Log表示用
     * @param logger ロガー
     */
    public void printFieldLog(Logger logger){
        logger.info("[Form] userName : " + this.userName);
        logger.info("[Form] email : " + this.email);
        logger.info("[Form] password : " + this.password);
    }
}
