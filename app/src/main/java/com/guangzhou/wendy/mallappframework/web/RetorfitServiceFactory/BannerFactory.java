package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import com.guangzhou.wendy.mallappframework.web.RetorfitService.BannerService;

/**
 * Created by yunhaipiaodi on 2017/8/17.
 */

public class BannerFactory extends BasicFactory {
    public BannerService create(){return super.retrofit.create(BannerService.class);}
}
