package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yunhaipiaodi on 2017/8/17.
 */

public class Banner implements Serializable {
    @SerializedName("banner") public List<BannerItem> bannerList;
}
