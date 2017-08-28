package com.guangzhou.wendy.mallappframework.web.RetorfitService;

import com.guangzhou.wendy.mallappframework.model.CommitOrderResult;
import com.guangzhou.wendy.mallappframework.model.GoodsOrder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


/**
 * Created by yunhaipiaodi on 2017/8/25.
 */

public interface GoodsOrderService {
    @GET
    public Call<CommitOrderResult> getGoodsOrderData(@Url String url);
}
