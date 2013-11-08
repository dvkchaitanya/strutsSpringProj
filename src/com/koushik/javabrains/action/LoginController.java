package com.koushik.javabrains.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by IntelliJ IDEA.
 * User: venkatakrishnachaita
 * Date: 11/6/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginController extends ActionSupport {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String validateUser(){
        if (userName.equals("desu")&& password.equals("desu123"))
        return SUCCESS;
        else return ERROR;
    }
}
