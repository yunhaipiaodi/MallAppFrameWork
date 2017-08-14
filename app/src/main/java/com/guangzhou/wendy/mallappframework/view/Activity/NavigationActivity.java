package com.guangzhou.wendy.mallappframework.view.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.model.NavBannerItem;
import com.guangzhou.wendy.mallappframework.viewmodel.Observable.NavigationBannerModel;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cn.bingoogolapple.bgabanner.BGABanner;

public class NavigationActivity extends AppCompatActivity implements Observer{

    BGABanner bgaBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        init();
    }

    private void init(){
        bgaBanner = (BGABanner)findViewById(R.id.banner_guide_content);
        bgaBanner.setAdapter(new BGABanner.Adapter<CardView,NavBannerItem>() {
            @Override
            public void fillBannerItem(BGABanner banner, CardView itemView, NavBannerItem model, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI(Uri.parse(model.pictureUrl));
            }
        });
        bgaBanner.setDelegate(new BGABanner.Delegate<CardView,NavBannerItem>() {
            @Override
            public void onBannerItemClick(BGABanner banner, CardView itemView, NavBannerItem model, int position) {
                openBannerLink(model.transUrl);
            }
        });
        bgaBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, R.id.tv_guide_skip, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                gotoMainActivity();
                NavigationActivity.this.finish();
            }
        });
        new NavigationBannerModel(this).addObserver(this);
    }

    //点击banner跳转到浏览器
    private void openBannerLink(String url){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            this.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //跳转到主页面
    private void gotoMainActivity(){
        try{
            Intent intent = new Intent(this,MainActivity.class);
            this.startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof NavigationBannerModel){
            NavigationBannerModel model = (NavigationBannerModel)o;
            List<NavBannerItem> navBannerItems = model.getData();
            List<String> tips = new ArrayList<>();
            bgaBanner.setData(R.layout.item_fresco,navBannerItems,tips);
        }

    }
}
