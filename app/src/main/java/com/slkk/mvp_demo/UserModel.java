package com.slkk.mvp_demo;

import android.text.TextUtils;

/**
 * Created by slkk on 18-3-1.
 */

public class UserModel {
    private String name;

    private String password;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int checkUserValidity(String name, String password) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            return -1;
        }
        return 0;
    }
}
