package com.Chat.Entity;

import com.Chat.Form.SigninFormModel;

/**
 * Userエンティティ
 * User: miyamoto_s
 * Date: 2013/10/18
 * Time: 22:06
 */
//@Entity
//@Proxy(lazy = false)
//@Table(name = "User")
public class User {

//    @Id
//    @Column (name = "id")
    private Integer id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "email")
    private String eMail;

//    @Column(name = "password")
    private String password;

//    @Column(name = "deleteFlag")
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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
