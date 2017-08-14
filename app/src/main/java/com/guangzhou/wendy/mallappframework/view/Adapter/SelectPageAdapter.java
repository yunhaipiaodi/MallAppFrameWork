package com.guangzhou.wendy.mallappframework.view.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.guangzhou.wendy.mallappframework.view.Fragment.HomeFragment;
import com.guangzhou.wendy.mallappframework.view.Fragment.MeFragment;
import com.guangzhou.wendy.mallappframework.view.Fragment.MessageFragment;
import com.guangzhou.wendy.mallappframework.view.Fragment.ShoppingCartFragment;

/**
 * Created by yunhaipiaodi on 2017/8/14.
 */

public class SelectPageAdapter extends FragmentPagerAdapter {
    private int itemCounts = 4;

    public SelectPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: // HomeFragment - 显示首页项
                return HomeFragment.newInstance();
            case 1: // ShoppingCartFragment - 显示购物车项
                return ShoppingCartFragment.newInstance();
            case 2: // MessageFragment - 显示消息选项
                return MessageFragment.newInstance();
            case 3: // MeFragment - 显示用户选项
                return MeFragment.newInstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return itemCounts;
    }
}
