package com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory;

import com.guangzhou.wendy.mallappframework.web.RetorfitService.NavigationBannerService;

/**
 * Created by yunhaipiaodi on 2017/8/10.
 */

public class NavBannerFactory extends BasicFactory {
    public NavigationBannerService create(){return super.retrofit.create(NavigationBannerService.class);}
}
