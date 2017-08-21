package com.guangzhou.wendy.mallappframework.view.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.guangzhou.wendy.mallappframework.R;
import com.guangzhou.wendy.mallappframework.view.Adapter.SelectPageAdapter;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager selectPage;
    AHBottomNavigation bottomNavigation;
    SelectPageAdapter selectPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setTitle("商城");
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.qr_scan:
                gotoQrCodeScanActivity();
                return true;
            case R.id.tool_search:
                gotoSearchActivity();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    //跳转到二维码扫描页面
    private void gotoQrCodeScanActivity(){
        Intent intent = new Intent(this,QrCodeScanActivity.class);
        startActivity(intent);
    }

    //跳转到搜寻页面
    private void gotoSearchActivity(){

    }

    private void init(){
        setToolbar();
        setSelectPage();
        setBottomNavigation();
    }

    private void setToolbar(){
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setSelectPage(){
        selectPage = (ViewPager)findViewById(R.id.select_page);
        selectPageAdapter = new SelectPageAdapter(getSupportFragmentManager());
        selectPage.setAdapter(selectPageAdapter);
        selectPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                bottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setBottomNavigation(){
        bottomNavigation= (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        //设置选项菜单
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this,R.menu.navigation);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation);
        //设置背景色(这一步也可以省略,AHBottomNavigation默认会去获取accentColor)
        bottomNavigation.setBackgroundColor(fetchAccentColor());
        //设置选项监听
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                selectPage.setCurrentItem(position);
                return true;
            }
        });
    }


    //获得ccentColor
    private int fetchAccentColor() {
        TypedValue typedValue = new TypedValue();

        TypedArray a = this.obtainStyledAttributes(typedValue.data, new int[] { R.attr.colorAccent });
        int color = a.getColor(0, 0);

        a.recycle();

        return color;
    }
}
