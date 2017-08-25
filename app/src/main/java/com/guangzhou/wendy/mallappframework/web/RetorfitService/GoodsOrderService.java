package com.guangzhou.wendy.mallappframework.web.RetorfitService;

import com.guangzhou.wendy.mallappframework.model.GoodsOrder;

import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by yunhaipiaodi on 2017/8/25.
 */

public interface GoodsOrderService {
    @POST("/commit_order.php")
    @FormUrlEncoded
    public String postGoodsOrderData(@Body GoodsOrder goodsOrder);
}
