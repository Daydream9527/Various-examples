package com.example.demoapplication.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoapplication.R;

public class Demo4Activity extends AppCompatActivity {

    public TextView textView;
    public CollapsingToolbarLayout collap;
    public AppBarLayout appBarLayout;
    public Toolbar toolbar;
    //因为setExpanded会调用事件监听，所以通过标志过滤掉
    public static int expendedtag=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_demo4);
        initview();
        setview();
//        listen();
    }

    public void initview(){
        textView= findViewById(R.id.text1);
        collap= findViewById(R.id.collap);
        appBarLayout=findViewById(R.id.barlayout);

        toolbar= findViewById(R.id.toolbar);
    }
    public void setview(){
        String s="一二三四五六七八九十";
        for(int i=0;i<7;i++){
            s+=s;
        }

        textView.setText(s);
        setSupportActionBar(toolbar);
        appBarLayout.setExpanded(false);

    }
    public void listen(){
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            //verticalOffset是当前appbarLayout的高度与最开始appbarlayout高度的差，向上滑动的话是负数
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //通过日志得出活动启动是两次，由于之前有setExpanded所以三次
                Log.d("启动活动调用监听次数","几次");
                if(getSupportActionBar().getHeight()-appBarLayout.getHeight()==verticalOffset){
                    //折叠监听
                    //Toast.makeText(MainActivity.this,"折叠了",Toast.LENGTH_SHORT).show();
                }
                if(expendedtag==2&&verticalOffset==0){
                    //展开监听
                    Toast.makeText(Demo4Activity.this,"展开了",Toast.LENGTH_SHORT).show();
                }
                if(expendedtag!=2&&verticalOffset==0){
                    expendedtag++;
                }
            }
        });
    }
}
