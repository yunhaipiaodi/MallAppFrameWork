package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import com.guangzhou.wendy.mallappframework.web.RetorfitService.LoginPicService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yunhaipiaodi on 2017/8/1.
 */

public class LoginPicServiceFactory extends BasicFactory{
    public LoginPicService create(){
        return super.retrofit.create(LoginPicService.class);
    }
}
