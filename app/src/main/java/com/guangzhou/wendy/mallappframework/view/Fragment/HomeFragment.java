package com.guangzhou.wendy.mallappframework.view.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.model.BannerItem;
import com.guangzhou.wendy.mallappframework.model.GoodsItem;
import com.guangzhou.wendy.mallappframework.viewmodel.Observable.BannerViewModel;
import com.guangzhou.wendy.mallappframework.viewmodel.Observable.GoodsViewModel;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    BGABanner banner;
    RecyclerView recyclerView;

    BannerViewModel bannerModel;
    GoodsViewModel goodsModel;

    public HomeFragment() {
        // Required empty public constructor
        setBannerModel();
    }

    private void setBannerModel(){
        bannerModel = new BannerViewModel(getContext());
        bannerModel.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if(o instanceof BannerViewModel){
                    BannerViewModel model = (BannerViewModel)o;
                    List<BannerItem> bannerItems = model.getData();
                    banner.setData(R.layout.item_fresco,bannerItems,null);
                }
            }
        });
    }

    private void setGoodsModel(){
        goodsModel = new GoodsViewModel(getContext());
        goodsModel.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if(o instanceof GoodsViewModel){
                    GoodsViewModel model = (GoodsViewModel)o;
                    List<GoodsItem> bannerItems = model.getData();
                    banner.setData(R.layout.item_fresco,bannerItems,null);
                }
            }
        });
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        //设置banner
        banner = (BGABanner)view.findViewById(R.id.banner_main_default);
        banner.setAdapter(new BGABanner.Adapter<CardView,BannerItem>() {
            @Override
            public void fillBannerItem(BGABanner banner, CardView itemView, BannerItem model, int position) {
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sdv_item_fresco_content);
                simpleDraweeView.setImageURI(Uri.parse(model.pictureUrl));
            }
        });
        banner.setDelegate(new BGABanner.Delegate<CardView,BannerItem>() {
            @Override
            public void onBannerItemClick(BGABanner banner, CardView itemView, BannerItem model, int position) {
                openBannerLink(model.transUrl);
            }
        });

        //设置RecyclerView
        recyclerView = (RecyclerView)view.findViewById(R.id.goods_list);
        return view;
    }

    //点击banner跳转到浏览器
    private void openBannerLink(String url){
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
            getActivity().startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
