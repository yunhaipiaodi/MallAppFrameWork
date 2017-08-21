package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public class GoodsItem implements Serializable {
    @SerializedName("id") public String id = "";
    @SerializedName("name") public String name = "";
    @SerializedName("price") public String price = "";
    @SerializedName("goods_type_id") public String goods_type_id = "";
}
