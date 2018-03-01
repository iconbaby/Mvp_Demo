package com.slkk.mvp_demo;

import android.os.Handler;
import android.util.Log;


/**
 * Created by slkk on 18-3-1.
 */

public class LoginPresenter implements IloginPresenter {
    private ILoginView loginView;
    private UserModel userModel;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        initUser();
    }

    private void initUser() {
        userModel = new UserModel(loginView.getUserName(), loginView.getPassword());
    }

    @Override
    public void login(String name, String password) {
        loginView.showProgress();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginView.hideProgress();
                int code = userModel.checkUserValidity(loginView.getUserName(), loginView.getPassword());
                if (code == -1) {
                    loginView.setPasswordError();
                } else {
                    loginView.loginSuccess();
                }
            }
        }, 2000);
    }
}
