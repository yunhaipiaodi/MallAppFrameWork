package com.guangzhou.wendy.mallappframework.view.Activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.databinding.ActivityGoodsBinding;
import com.guangzhou.wendy.mallappframework.model.BannerItem;
import com.guangzhou.wendy.mallappframework.model.GoodsOrder;
import com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable.GoodsActivityViewModel;
import com.lljjcoder.city_20170724.CityPickerView;
import com.lljjcoder.city_20170724.bean.CityBean;
import com.lljjcoder.city_20170724.bean.DistrictBean;
import com.lljjcoder.city_20170724.bean.ProvinceBean;

import java.net.URLEncoder;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;

public class GoodsActivity extends AppCompatActivity {

    CityPickerView cityPicker;
    ActivityGoodsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
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
                binding.getGoodsActivityData().fetchGoodsOrder(getGoodsCommitUrl());
            }
        });

        String id = getIntent().getStringExtra("goods_id");
        binding.setGoodsActivityData(new GoodsActivityViewModel(this,id,new GoodsActivityViewModel.Listener(){
            @Override
            public void updatePicUrlList(List<String> picUrlList) {
                setBanner(binding.goodsPictureList,picUrlList);
            }
        }));

        binding.selectAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityPicker.show();
            }
        });

        setCityPicker();
    }

    private String getGoodsCommitUrl(){
        String goodsId = binding.getGoodsActivityData().getId();
        String count = "1";
        String totalPrice = binding.getGoodsActivityData().getPrice();
        String userId = "-1";
        String userAddrId = "-1";
        String sendAddr= "-1";
        try{
            sendAddr = URLEncoder.encode(binding.recentAddress.getText().toString(),"utf8");
        }catch (Exception e){
            e.printStackTrace();
        }

        String stateId = "0";
        String url = String.format("http://120.24.61.188:9999/commit_order.php?goods_id=%s&" +
                "count=%s&" +
                "total_price=%s&" +
                "user_id=%s&" +
                "user_addr_id=%s&" +
                "send_addr=%s&" +
                "state_id=%s&",goodsId,count,totalPrice,userId,userAddrId, sendAddr,stateId);
        return url;
    }

    private void setCityPicker(){
        cityPicker = new CityPickerView.Builder(this)
                .textSize(20)
                .title("地址选择")
                .backgroundPop(0xa0000000)
                .titleBackgroundColor("#234Dfa")
                .titleTextColor("#000000")
                .backgroundPop(0xa0000000)
                .confirTextColor("#000000")
                .cancelTextColor("#000000")
                .province("广东省")
                .city("广州市")
                .district("天河区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        //监听方法，获取选择结果
        cityPicker.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean provinceBean, CityBean cityBean, DistrictBean districtBean) {
                String address = provinceBean.getName()+">"+cityBean.getName()+">"+districtBean.getName();
                binding.recentAddress.setText(address);
            }

            @Override
            public void onCancel() {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.goods_activity_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.heart_it:
                Toast.makeText(this,"like it",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return  super.onOptionsItemSelected(menuItem);
        }
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
