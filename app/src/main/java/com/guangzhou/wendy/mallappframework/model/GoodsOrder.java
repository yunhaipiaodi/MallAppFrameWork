package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by yunhaipiaodi on 2017/8/25.
 */

public class GoodsOrder implements Serializable {
    @SerializedName("goods_id") public String goodsId = "";
    @SerializedName("count") public String count = "";
    @SerializedName("total_price") public String totalPrice = "";
    @SerializedName("user_id") public String userId = "";
    @SerializedName("user_addr_id") public String userAddrId = "";
    @SerializedName("send_addr") public String sendAddr = "";
    @SerializedName("state_id") public String stateId = "";

    public GoodsOrder(String goodsId,String count,String totalPrice,
                      String userId ,String userAddrId ,String sendAddr,String stateId){
        this.goodsId = goodsId;
        this.count = count;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.userAddrId = userAddrId;
        this.sendAddr = sendAddr;
        this.stateId = stateId;
    }
}
