package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import com.guangzhou.wendy.mallappframework.web.RetorfitService.GoodsDetailService;

/**
 * Created by yunhaipiaodi on 2017/8/22.
 */

public class GoodsDetailFactory extends BasicFactory {
    public GoodsDetailService create(){return super.retrofit.create(GoodsDetailService.class);}
}
