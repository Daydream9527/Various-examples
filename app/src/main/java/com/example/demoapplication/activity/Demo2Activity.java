package com.example.demoapplication.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoapplication.R;
import com.example.demoapplication.bean.AbilityBean;
import com.example.demoapplication.view.AbilityMapView;


public class Demo2Activity extends AppCompatActivity {
    private AbilityMapView abilitymapview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        initView();
    }

    private void initView() {
        this.abilitymapview = (AbilityMapView) findViewById(R.id.ability_map_view);
        abilitymapview.setData(new AbilityBean(65, 70, 80, 70, 80, 80, 80));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                abilitymapview.setData(new AbilityBean(30, 50, 40, 70, 80, 40, 40));
            }
        }, 4000);
    }
}
