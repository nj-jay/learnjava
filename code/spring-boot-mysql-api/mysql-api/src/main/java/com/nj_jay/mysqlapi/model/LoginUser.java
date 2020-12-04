package com.nj_jay.mysqlapi.model;

import com.alibaba.fastjson.annotation.JSONType;

@JSONType(orders = {"username", "password"})
public class LoginUser {

    String username;

    String password;

    public LoginUser() {

    }

    public LoginUser(String username, String password) {

        this.username = username;
        this.password = password;

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
