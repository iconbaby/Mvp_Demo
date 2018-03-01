package com.slkk.mvp_demo;

/**
 * Created by slkk on 18-3-1.
 */

public interface ILoginView {
    void showProgress();

    void hideProgress();

    void setPasswordError();

    String getUserName();

    String getPassword();

    void loginSuccess();
}
