package com.example.demoapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.demoapplication.R;

/**
 * Created by Administrator on 2018/2/11 0011.
 */

public class MyView extends View{
    private int cx;
    private int cy;
    private int radius;
    private int color;
    private Context mcontext;
    private Paint paint;

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mcontext=context;
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(){
        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.app_color));
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }
//    public void setData(int x,int y,int rasius,int color){
//        this.cx=x;
//        this.cy=y;
//        this.radius=rasius;
//        this.color=color;
//    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(R.color.colorAccent));

//        canvas.drawCircle(300,300,200,paint);
//        canvas.drawRect(100, 100, 600, 600, paint);
//        float[] points = {0, 0, 50, 50, 50, 100, 100, 50, 100, 100, 150, 50, 150, 100};
//        // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
//        canvas.drawPoints(points, 2 /* 跳过两个数，即前两个 0 */,
//                8 /* 一共绘制 8 个数（4 个点）*/, paint);
//        canvas.drawOval(50, 50, 350, 200, paint);
//        canvas.drawArc(200, 100, 500, 500,
//                -110, 100, true, paint); // 绘制扇形
        canvas.drawArc(200, 100, 800, 500, 180,
                60, false, paint); // 绘制不封口的弧形

    }
}
