package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunhaipiaodi on 2017/8/22.
 */

public class GoodsDetail implements Serializable {
    @SerializedName("id") public String id = "";
    @SerializedName("name") public String name = "";
    @SerializedName("price") public String price = "";
    @SerializedName("pic_url_list") public List<String> picUrlList = new ArrayList<>();
    @SerializedName("goods_type_id") public String goods_type_id = "";
}
