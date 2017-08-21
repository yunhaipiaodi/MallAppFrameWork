package com.guangzhou.wendy.mallappframework.viewmodel.Observable;

import android.content.Context;

import com.guangzhou.wendy.mallappframework.model.Banner;
import com.guangzhou.wendy.mallappframework.model.Goods;
import com.guangzhou.wendy.mallappframework.model.GoodsItem;
import com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory.BannerFactory;
import com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory.GoodsFactory;

import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunhaipiaodi on 2017/8/18.
 */

public class GoodsViewModel extends Observable {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<GoodsItem> goodsItems;
    private Context context;

    private String requestUrl = "http://120.24.61.188:9999/getGoods.php";

    public GoodsViewModel(Context mContext){
        this.context = mContext;
        fetchNavigationGoods();
    }

    private void setData(List<GoodsItem> goodsItems){
        this.goodsItems = goodsItems;
        setChanged();
        notifyObservers();
    }


    public List<GoodsItem> getData(){return this.goodsItems;}

    private void fetchNavigationGoods(){
        compositeDisposable.add(new GoodsFactory().create()
                .getObservable(requestUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Goods>() {
                    @Override
                    public void accept(@NonNull Goods goods) throws Exception {
                        setData(goods.goodsList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                }));
    }

    public void reset(){
        if(compositeDisposable != null && compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
        compositeDisposable = null;
        context = null;
    }
}
