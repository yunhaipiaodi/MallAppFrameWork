package com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guangzhou.wendy.mallappframework.model.GoodsItem;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public class GoodsItemViewModel extends BaseObservable {
    private GoodsItem goodsItem;
    private Context mContext;

    public GoodsItemViewModel(GoodsItem goodsItem,Context context){
        this.goodsItem = goodsItem;
        this.mContext = context;
    }

    public void setGoodsItem(GoodsItem goodsItem){
        this.goodsItem = goodsItem;
        notifyChange();
    }

    public String getId(){return goodsItem.id;}

    public String getName(){return goodsItem.name;}

    public String getPrice() {return goodsItem.price;}

    public String getPicUrl(){return  goodsItem.picUrl;}

    public String getGoodsTypeId(){return goodsItem.goods_type_id;}

    @BindingAdapter("load_image") public static void setImageUrl(SimpleDraweeView simpleDraweeView, String url) {
        Log.i("GoodsItemViewModel","loadImage,url:" + url);
        if(simpleDraweeView == null){
            Log.d("GoodsItemViewModel","simpleDraweeView is null");
        }
        Uri uri = Uri.parse(url);
        simpleDraweeView.setImageURI(uri);
    }



}
