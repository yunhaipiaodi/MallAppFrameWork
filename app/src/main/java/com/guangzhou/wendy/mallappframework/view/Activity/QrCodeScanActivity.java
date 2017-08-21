package com.guangzhou.wendy.mallappframework.view.Activity;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.guangzhou.wendy.mallappframework.R;

import cn.bingoogolapple.qrcode.core.QRCodeView;

public class QrCodeScanActivity extends AppCompatActivity implements QRCodeView.Delegate{

    private static final String TAG = QrCodeScanActivity.class.getSimpleName();
    private QRCodeView qrCodeView;
    private Toolbar toolbar;
    private Button openLightBtn;

    private boolean hasOpenLightBtn =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scan);
        init();
    }

    @Override
    protected void onStart() {
        super.onStart();
        qrCodeView.startCamera();
//        mQRCodeView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);

        qrCodeView.showScanRect();
        qrCodeView.startSpot();
    }

    @Override
    protected void onStop() {
        qrCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        qrCodeView.onDestroy();
        super.onDestroy();
    }

    private void init(){
        setQrCodeView();
        setToolbar();
        setOpenLightBtn();
    }

    private void setQrCodeView(){
        qrCodeView = (QRCodeView)findViewById(R.id.zxingview);
        qrCodeView.setDelegate(this);

    }

    private void setToolbar(){
        toolbar = (Toolbar)findViewById(R.id.qr_scan_toolbar);
        setSupportActionBar(toolbar);
        setTitle("扫描二维码");
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setOpenLightBtn(){
        openLightBtn = (Button)findViewById(R.id.open_light_btn);
        openLightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hasOpenLightBtn){
                    openFlashlight();
                }else{
                    closeFlashlight();
                }
            }
        });
    }

    private void openFlashlight(){
        qrCodeView.openFlashlight();
        openLightBtn.setText("关闭闪光灯");
        hasOpenLightBtn = true;
    }

    private void closeFlashlight(){
        qrCodeView.closeFlashlight();
        openLightBtn.setText("打开闪光灯");
        hasOpenLightBtn = false;
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        //这里输出二维码地址——result
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();
        qrCodeView.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }
}
