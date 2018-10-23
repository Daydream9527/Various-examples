package com.example.demoapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.demoapplication.R;
import com.example.demoapplication.praticeview.Practice1View;

public class Demo7Activity extends AppCompatActivity {

    private Practice1View practice1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7);
        initView();
    }

    private void initView() {
        practice1 = (Practice1View) findViewById(R.id.practice1);
    }
}
