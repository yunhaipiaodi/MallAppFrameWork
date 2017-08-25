package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import com.guangzhou.wendy.mallappframework.web.RetorfitService.BannerService;
import com.guangzhou.wendy.mallappframework.web.RetorfitService.GoodsOrderService;

/**
 * Created by yunhaipiaodi on 2017/8/25.
 */

public class GoodsOrderFactory extends BasicFactory {
    public GoodsOrderService create(){return super.retrofit.create(GoodsOrderService.class);}
}
