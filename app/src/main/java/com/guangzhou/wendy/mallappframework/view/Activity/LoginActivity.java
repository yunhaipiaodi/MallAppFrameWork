package com.guangzhou.wendy.mallappframework.view.Activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.databinding.ActivityLoginBinding;
import com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding activityLoginBinding;
    private LoginViewModel loginViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
    }

    private void initBinding(){
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginViewModel = new LoginViewModel(this);
        activityLoginBinding.setLoginViewData(loginViewModel);
    }


}
