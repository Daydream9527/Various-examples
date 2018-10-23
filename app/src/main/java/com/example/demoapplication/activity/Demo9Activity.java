package com.example.demoapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.demoapplication.R;

/**
 * 动画
 */
public class Demo9Activity extends AppCompatActivity {

    private TextView tv_animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo9);
        initView();
    }

    private void initView() {
        tv_animation = (TextView) findViewById(R.id.tv_animation);
        //位移动画
        //方式1
//        Animation translateAnimation= AnimationUtils.loadAnimation(this,R.anim.view_animation);
//        translateAnimation.setRepeatCount(3);
//        tv_animation.startAnimation(translateAnimation);
        //方式2
//        Animation translateAnimation=new TranslateAnimation(0,500,0,500);
//        translateAnimation.setRepeatCount(2);
//        translateAnimation.setDuration(3000);
//        tv_animation.startAnimation(translateAnimation);
        //缩放
        Animation scaleAnimation=AnimationUtils.loadAnimation(this,R.anim.view_animation);
        tv_animation.startAnimation(scaleAnimation);
    }
}
