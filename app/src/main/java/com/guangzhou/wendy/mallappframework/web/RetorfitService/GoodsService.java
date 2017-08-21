package com.guangzhou.wendy.mallappframework.web.RetorfitService;

import com.guangzhou.wendy.mallappframework.model.Goods;
import com.guangzhou.wendy.mallappframework.model.NavigationBanner;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public interface GoodsService {
    @GET
    public Observable<Goods> getObservable(@Url String url);
}
