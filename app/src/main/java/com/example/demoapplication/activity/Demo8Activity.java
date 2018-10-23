package com.example.demoapplication.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.demoapplication.R;
import com.example.demoapplication.bean.DataDemoBean;
import com.example.demoapplication.databinding.ActivityDemo8Binding;

public class Demo8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDemo8Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_demo8);
        DataDemoBean dataDemoBean=new DataDemoBean("123","hhh","d");
        binding.setUser(dataDemoBean);
    }
}
