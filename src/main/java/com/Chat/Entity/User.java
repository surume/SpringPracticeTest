package com.Chat.Entity;

import com.Chat.Form.SigninFormModel;

/**
 * Userエンティティ
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:06
 */
public class User {

    private Integer id;

    private String name;

    private String eMail;

    private String password;

    private int deleteFlag;

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

    public boolean isDeleteFlag() {
        return deleteFlag != 0;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag? 1:0;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
