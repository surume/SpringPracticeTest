package com.Chat.Entity;

import com.Chat.Form.SigninFormModel;
import com.mysql.jdbc.StringUtils;

/**
 * Userエンティティ
 * User: miyamoto_s
 * Date: 2013/10/18
 */
public class User {

    private Integer id;

    private String name;

    private String eMail;

    private String password;

    private String tokenId;

    private boolean validFlag;

    private boolean deleteFlag;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(SigninFormModel signinFormModel) {
        this.name = signinFormModel.getUserName();
        this.eMail = signinFormModel.getEmail();
        this.password = signinFormModel.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public boolean isValidFlag() {
        return validFlag;
    }

    public void setValidFlag(boolean validFlag) {
        this.validFlag = validFlag;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public boolean checkNullField() {
        return StringUtils.isNullOrEmpty(eMail)
                || StringUtils.isNullOrEmpty(name);
    }
}
