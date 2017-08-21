package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by yunhaipiaodi on 2017/8/17.
 */

public class BannerItem implements Serializable {
    @SerializedName("picture_url") public String pictureUrl = "";
    @SerializedName("trans_url") public String transUrl = "";
}
