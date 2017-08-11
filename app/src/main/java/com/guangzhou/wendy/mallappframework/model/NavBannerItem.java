package com.guangzhou.wendy.mallappframework.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by yunhaipiaodi on 2017/8/10.
 */

public class NavBannerItem implements Serializable {
    @SerializedName("picture_url") public String pictureUrl = "";
    @SerializedName("explain_text") public String explainText = "";
    @SerializedName("trans_url") public String transUrl = "";
}
