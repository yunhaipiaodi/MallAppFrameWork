package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import com.guangzhou.wendy.mallappframework.web.RetorfitService.BannerService;
import com.guangzhou.wendy.mallappframework.web.RetorfitService.GoodsService;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public class GoodsFactory extends BasicFactory {
    public GoodsService create(){return super.retrofit.create(GoodsService.class);}
}
