package com.guangzhou.wendy.mallappframework.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yunhaipiaodi on 2017/8/10.
 */

public class NavigationBanner implements Serializable{
    @SerializedName("nav_banner") public List<NavBannerItem> navBanner;
}
