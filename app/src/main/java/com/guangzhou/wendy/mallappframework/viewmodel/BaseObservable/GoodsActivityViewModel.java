package com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable;

import android.content.Context;
import android.databinding.BaseObservable;

import com.guangzhou.wendy.mallappframework.model.BannerItem;
import com.guangzhou.wendy.mallappframework.model.GoodsDetail;
import com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory.GoodsDetailFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunhaipiaodi on 2017/8/21.
 */

public class GoodsActivityViewModel extends BaseObservable {
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private GoodsDetail goodsDetail = new GoodsDetail();
    private Context context;
    private Listener mListener;

    private String requestUrl = "http://120.24.61.188:9999/getGoodsDetail.php";

    public GoodsActivityViewModel(Context mContext,String id,Listener listener){
        this.context = mContext;
        this.mListener = listener;
        requestUrl += ("?id=" + id);
        fetchGoodsDetail();
    }

    private void setData(GoodsDetail goodsDetail){
        this.goodsDetail = goodsDetail;
        notifyChange();
    }

    public String getId(){return goodsDetail.id;}

    public String getName(){return goodsDetail.name;}

    public String getPrice() {return goodsDetail.price;}

    public List<String> getPicUrlList(){return  goodsDetail.picUrlList;}

    public String getGoodsTypeId(){return goodsDetail.goods_type_id;}

    private void fetchGoodsDetail(){
        compositeDisposable.add(new GoodsDetailFactory()
                .create()
                .getObservable(requestUrl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsDetail>() {
                    @Override
                    public void accept(@NonNull GoodsDetail goodsDetail) throws Exception {
                        setData(goodsDetail);
                        mListener.updatePicUrlList(goodsDetail.picUrlList);
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

    public interface Listener{
        public void updatePicUrlList(List<String> picUrlList);
    }
}
