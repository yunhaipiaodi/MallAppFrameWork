package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public class Goods implements Serializable {
    @SerializedName("goods") public List<GoodsItem> goodsList;
}
