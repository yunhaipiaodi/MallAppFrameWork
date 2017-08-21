package com.guangzhou.wendy.mallappframework.viewmodel.Observable;

import android.content.Context;

import com.guangzhou.wendy.mallappframework.model.Banner;
import com.guangzhou.wendy.mallappframework.model.BannerItem;
import com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory.BannerFactory;

import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunhaipiaodi on 2017/8/21.
 */

public class GoodsActivityBannerViewModel extends Observable {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<BannerItem> Banners;
    private Context context;

    private String requestUrl = "";

    public GoodsActivityBannerViewModel(Context mContext){
        this.context = mContext;
        fetchNavigationBanner();
    }

    private void setData(List<BannerItem> Banners){
        this.Banners = Banners;
        setChanged();
        notifyObservers();
    }


    public List<BannerItem> getData(){return this.Banners;}

    private void fetchNavigationBanner(){
        compositeDisposable.add(new BannerFactory().create()
                .getObservable(requestUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Banner>() {
                    @Override
                    public void accept(@NonNull Banner banner) throws Exception {
                        setData(banner.bannerList);
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
