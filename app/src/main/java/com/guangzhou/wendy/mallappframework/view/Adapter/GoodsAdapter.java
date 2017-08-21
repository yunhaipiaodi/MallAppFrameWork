package com.guangzhou.wendy.mallappframework.view.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.databinding.GoodsItemBinding;
import com.guangzhou.wendy.mallappframework.model.GoodsItem;
import com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable.GoodsItemViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.ViewHolder> {

    private List<GoodsItem> goodsItems ;
    private Context mContext;

    public GoodsAdapter(Context context){
        this.goodsItems = Collections.emptyList();
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GoodsItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.goods_item,parent,false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindGoodsItem(goodsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return goodsItems.size();
    }

    public void setGoodsItems(List<GoodsItem> goodsItemList){
        this.goodsItems = goodsItemList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private GoodsItemBinding itemBinding;

        public ViewHolder(GoodsItemBinding itemBinding) {
            super(itemBinding.itemContainer);
            this.itemBinding = itemBinding;
        }

        void bindGoodsItem(final GoodsItem goodsItem){
            if(itemBinding.getGoodsItemViewModel() == null){
                itemBinding.setGoodsItemViewModel(new GoodsItemViewModel(goodsItem,mContext));
            }else{
                itemBinding.getGoodsItemViewModel().setGoodsItem(goodsItem);
            }

            //增加点击事件
            itemBinding.goodsPicture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到商品展示页面
                    transToGoodsActivity(goodsItem.id);
                }
            });

            itemBinding.goodsName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //跳转到商品展示页面
                    transToGoodsActivity(goodsItem.id);
                }
            });

            itemBinding.addShoppingCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //添加商品到购物车
                    addShoppingCart(goodsItem.id);
                }
            });
        }
    }

    //跳转到商品展示页面
    private void transToGoodsActivity(String goodsId){

    }

    //将商品添加至购物车
    private void addShoppingCart(String goodsId){
        Toast.makeText(mContext,"暂没实现",Toast.LENGTH_SHORT).show();
    }


}
