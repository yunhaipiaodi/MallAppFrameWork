package com.guangzhou.wendy.mallappframework.viewmodel.Observable;

import android.content.Context;

import com.guangzhou.wendy.mallappframework.model.NavBannerItem;
import com.guangzhou.wendy.mallappframework.model.NavigationBanner;
import com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory.NavBannerFactory;

import java.util.List;
import java.util.Observable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunhaipiaodi on 2017/8/10.
 */

public class NavigationBannerViewModel extends Observable {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<NavBannerItem> navBanners;
    private Context context;

    private String requestUrl = "http://120.24.61.188:9999/getNavigationBanner.php";

    public NavigationBannerViewModel(Context mContext){
        this.context = mContext;
        fetchNavigationBanner();
    }

    private void setData(List<NavBannerItem> mNavBanners){
        this.navBanners = mNavBanners;
        setChanged();
        notifyObservers();
    }


    public List<NavBannerItem> getData(){return this.navBanners;}

    private void fetchNavigationBanner(){
        compositeDisposable.add(new NavBannerFactory().create()
                .getObservable(requestUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NavigationBanner>() {
                    @Override
                    public void accept(@NonNull NavigationBanner navigationBanner) throws Exception {
                        setData(navigationBanner.navBanner);
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
