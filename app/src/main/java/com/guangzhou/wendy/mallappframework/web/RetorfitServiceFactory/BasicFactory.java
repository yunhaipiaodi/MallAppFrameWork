package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yunhaipiaodi on 2017/8/2.
 */

public class BasicFactory {
    protected String baseUrl = "http://120.24.61.188:9999/";
    protected Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
}
