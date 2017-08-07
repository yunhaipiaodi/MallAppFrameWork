package com.guangzhou.wendy.mallappframework.web.RetorfitService;



import com.guangzhou.wendy.mallappframework.model.LoginPicture;

import retrofit2.http.GET;
import io.reactivex.Observable;
import retrofit2.http.Url;

/**
 * Created by yunhaipiaodi on 2017/8/1.
 */

public interface LoginPicService {
    @GET public Observable<LoginPicture> getObservable(@Url String url);
}
