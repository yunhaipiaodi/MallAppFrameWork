package com.guangzhou.wendy.mallappframework.web.RetorfitService;

import com.guangzhou.wendy.mallappframework.model.Banner;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by yunhaipiaodi on 2017/8/17.
 */

public interface BannerService {
    @GET
    public Observable<Banner> getObservable(@Url String url);
}
