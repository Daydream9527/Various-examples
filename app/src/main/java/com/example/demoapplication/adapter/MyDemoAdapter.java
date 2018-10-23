package com.example.demoapplication.adapter;


import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.demoapplication.R;
import com.example.demoapplication.bean.DataDemoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/25 0025.
 */

public class MyDemoAdapter extends BaseQuickAdapter<DataDemoBean, BaseViewHolder> {

    public MyDemoAdapter(int layoutResId, @Nullable List<DataDemoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataDemoBean item) {
        helper.setText(R.id.tv_title,item.getTitle())
        .setText(R.id.tv_content,item.getWords())
        .setImageResource(R.id.iv_img, R.mipmap.h1);
    }
}
