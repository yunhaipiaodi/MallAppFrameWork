package com.guangzhou.wendy.mallappframework.view.Activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.databinding.ActivityLoginBinding;
import com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding activityLoginBinding;
    private LoginViewModel loginViewModel;

    private int delayTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();

        delayTrans();
    }

    private void initBinding(){
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginViewModel = new LoginViewModel(this);
        activityLoginBinding.setLoginViewData(loginViewModel);
    }

    //延时几秒再跳转
    private void delayTrans(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                transToNavigationActivity();
            }
        },delayTime);
    }

    private void transToNavigationActivity(){
        Intent intent = new Intent(this,NavigationActivity.class);
        startActivity(intent);
        this.finish();
    }
}
