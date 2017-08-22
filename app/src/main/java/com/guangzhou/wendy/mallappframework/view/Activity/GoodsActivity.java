package com.guangzhou.wendy.mallappframework.view.Activity;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.databinding.ActivityGoodsBinding;
import com.guangzhou.wendy.mallappframework.model.BannerItem;
import com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable.GoodsActivityViewModel;

import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

public class GoodsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityGoodsBinding binding =
                DataBindingUtil.setContentView(this,R.layout.activity_goods);
        setSupportActionBar(binding.toolbarDefault);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setTitle("");

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String id = getIntent().getStringExtra("goods_id");
        binding.setGoodsActivityData(new GoodsActivityViewModel(this,id,new GoodsActivityViewModel.Listener(){
            @Override
            public void updatePicUrlList(List<String> picUrlList) {
                setBanner(binding.goodsPictureList,picUrlList);
            }
        }));

    }


    private void setBanner(BGABanner banner,List<String> urls){
        banner.setAdapter(new BGABanner.Adapter<CardView,String>() {
            @Override
            public void fillBannerItem(BGABanner banner, CardView itemView, String url, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI(Uri.parse(url));
            }
        });

        banner.setData(R.layout.item_fresco,urls,null);
    }
}
