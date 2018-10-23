package com.example.demoapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.demoapplication.R;
import com.example.demoapplication.adapter.MyDemoAdapter;
import com.example.demoapplication.bean.DataDemoBean;

import java.util.ArrayList;
import java.util.List;

import static com.chad.library.adapter.base.BaseQuickAdapter.SLIDEIN_LEFT;

public class Demo5Activity extends AppCompatActivity {

    private RecyclerView rc_demo;
    private MyDemoAdapter adapter;
    private List<DataDemoBean> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5);
        initView();
    }

    private void initView() {
        rc_demo = (RecyclerView) findViewById(R.id.rc_demo);
        //模拟的数据（实际开发中一般是从网络获取的）
        datas = new ArrayList<>();
        DataDemoBean model;
        for (int i = 0; i < 15; i++) {
            model = new DataDemoBean();
            model.setTitle("我是第" + i + "条标题");
            model.setWords("第" + i + "条内容");
            datas.add(model);
        }
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rc_demo.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new MyDemoAdapter(R.layout.adapter_demo, datas);
        //开启动画（默认为渐显效果）
        adapter.openLoadAnimation(SLIDEIN_LEFT );
        rc_demo.setAdapter(adapter);
    }
}
