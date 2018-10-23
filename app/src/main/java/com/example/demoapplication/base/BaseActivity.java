package com.example.demoapplication.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoapplication.broadcast.NetBroadcastReceiver;

public class BaseActivity extends AppCompatActivity {
    NetBroadcastReceiver netWorkStateReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initNetWork();
    }
    private void initNetWork(){
        if (netWorkStateReceiver == null) {
            netWorkStateReceiver = new NetBroadcastReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netWorkStateReceiver, filter);
        System.out.println("注册");
    }
    //onPause()方法注销
    @Override
    protected void onPause() {
        unregisterReceiver(netWorkStateReceiver);
        System.out.println("注销");
        super.onPause();
    }
}
