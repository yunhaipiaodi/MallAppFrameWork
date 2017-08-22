package com.guangzhou.wendy.mallappframework.web.RetorfitService;

import com.guangzhou.wendy.mallappframework.model.GoodsDetail;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by yunhaipiaodi on 2017/8/22.
 */

public interface GoodsDetailService {
    @GET
    public Observable<GoodsDetail> getObservable(@Url String url);
}
