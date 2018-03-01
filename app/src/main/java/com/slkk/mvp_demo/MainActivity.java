package com.slkk.mvp_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

    private ProgressBar pb;
    private EditText et_userName;
    private EditText et_userPwd;
    private Button bt_login;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = findViewById(R.id.progressbar);
        et_userName = findViewById(R.id.et_usr_name);
        et_userPwd = findViewById(R.id.et_usr_pwd);
        bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void showProgress() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setPasswordError() {
        et_userPwd.setError("password error");
    }

    @Override
    public String getUserName() {
        return et_userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return et_userPwd.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"login success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        loginPresenter.login(et_userName.getText().toString(),et_userPwd.getText().toString());
    }
}
