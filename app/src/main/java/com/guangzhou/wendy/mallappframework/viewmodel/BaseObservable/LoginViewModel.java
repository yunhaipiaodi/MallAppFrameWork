package com.guangzhou.wendy.mallappframework.viewmodel.BaseObservable;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.net.Uri;
import android.util.Log;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guangzhou.wendy.mallappframework.model.LoginPicture;
import com.guangzhou.wendy.mallappframework.web.RetorfitServiceFactory.LoginPicServiceFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yunhaipiaodi on 2017/7/31.
 */

public class LoginViewModel extends BaseObservable{
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private String requesturl = "http://120.24.61.188:9999/getPicUrl.php";
    private static String TAG = "LoginViewModel";

    private LoginPicture loginPicture = new LoginPicture();
    private Context context;

    public LoginViewModel(Context mContext){
        this.context = mContext;
        fetchLoginPic();
    }

    public String getPicUrl(){return loginPicture.picUrl ;}

    protected void fetchLoginPic() {
        compositeDisposable.add( new LoginPicServiceFactory().create()
                .getObservable(requesturl)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginPicture>() {
                    @Override
                    public void accept(LoginPicture loginPicture) throws Exception {
                        updateData(loginPicture);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                }));
    }

    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset(){
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

    protected void updateData(LoginPicture mLoginPicture){
        loginPicture = mLoginPicture;
        notifyChange();
    }

    @BindingAdapter("load_image")
    public static void loadImage(SimpleDraweeView view, String url){
        Log.d(TAG,"loadImage,url:" +url);
        Uri uri = Uri.parse(url);
        view.setImageURI(uri);
    }


}
