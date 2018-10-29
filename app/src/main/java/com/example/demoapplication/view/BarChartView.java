package com.example.demoapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.example.demoapplication.R;
import com.example.demoapplication.util.StrUtil;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

/**
 * 柱状统计图
 * create by dayDream
 * 2018/10/23
 */
public class BarChartView extends View {

    private Paint paint;
    private Context mContext;
    private Path path;
    private int width;
    private int height;

    private double[] value = {0f, 0f, 0f, 0f, 0f, 0f, 0f};
    private int[] date = {0, 0, 0, 0, 0, 0, 0};
    private int[] color = {0, 0, 0, 0, 0, 0, 0};

    public BarChartView(Context context) {
        super(context);
        init();
    }

    public BarChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    public BarChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BarChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private void init(){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;         // 屏幕宽度（像素）
        height = dm.heightPixels;       // 屏幕高度（像素）

        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.white)); //画笔颜色
        paint.setStyle(Paint.Style.STROKE); //这里是设置填充模式还是画线
        paint.setStrokeWidth(3);  //这里是设置线条的宽度
        paint.setAntiAlias(true); //这里是设置抗锯齿
        paint.setTextSize(StrUtil.sp2px(13));   //这里是设置字体大小

        //统计图的框架
        path=new Path();
//        path.rMoveTo(50,420);//不显示y轴
        path.rMoveTo(QMUIDisplayHelper.dpToPx(20),height/5);//不显示y轴
        //显示y轴
//        path.rMoveTo(50,20);
//        path.lineTo(50,420);
        path.rLineTo(width-QMUIDisplayHelper.dpToPx(40),0);
        width = width-QMUIDisplayHelper.dpToPx(40);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paintText=new Paint();
        paintText.setColor(getResources().getColor(R.color.white)); //画笔颜色
        paintText.setStyle(Paint.Style.FILL); //这里是设置填充模式还是画线
        paintText.setStrokeWidth(QMUIDisplayHelper.dpToPx(1));  //这里是设置线条的宽度
        paintText.setAntiAlias(true); //这里是设置抗锯齿
        paintText.setTextSize(StrUtil.sp2px(12));   //这里是设置字体大小
        canvas.drawPath(path,paint);
        //x轴上的点
        Paint paintText1=new Paint();
        paintText1.setColor(getResources().getColor(R.color.white)); //画笔颜色
        paintText1.setStrokeWidth(QMUIDisplayHelper.dpToPx(4));
        paintText1.setStrokeCap(Paint.Cap.ROUND);

        double y=0; //y轴的平均值
        double num=0; //y轴上最大的值
        for (int i=0;i<value.length;i++){
            if (num<value[i]){
                num=value[i];
            }
        }
        y=(height/5-QMUIDisplayHelper.dpToPx(20))/num;
        Paint paintY=new Paint();
        paintY.setStyle(Paint.Style.FILL); //这里是设置填充模式还是画线
        paintY.setStrokeWidth(QMUIDisplayHelper.dpToPx(1));  //这里是设置线条的宽度
        paintY.setAntiAlias(true); //这里是设置抗锯齿
        paintY.setTextSize(StrUtil.sp2px(10));   //这里是设置字体大小
        int x=value.length*2+1;
        for (int i=0;i<value.length;i++){
            if (!(color==null||color.length<=0)){
                //彩色
                paintText.setColor(color[i]); //画笔颜色
                //y轴的值
                paintY.setColor(color[i]); //画笔颜色
                //y轴要显示的值
                canvas.drawText("￥"+value[i],(i*2+1)*(width/x)+QMUIDisplayHelper.dpToPx(16),
                        height/5-Float.parseFloat((value[i]*y)+"")-QMUIDisplayHelper.dpToPx(4), paintY);
            }else{
                //白色图  没有X轴这条线及X轴上的值
                //X轴的值要显示的值
                canvas.drawText(date[i]+"",(i*2+1)*(width/x)+QMUIDisplayHelper.dpToPx(20),
                        height/5+QMUIDisplayHelper.dpToPx(15),paintText);
                //y轴的值
                canvas.drawText("￥"+value[i],(i*2+1)*(width/x)+QMUIDisplayHelper.dpToPx(16),
                        height/5-Float.parseFloat((value[i]*y)+"")-QMUIDisplayHelper.dpToPx(4), paintText);
                //x轴上的点
                canvas.drawPoint((i*2+1)*(width/x)+width/x/2+QMUIDisplayHelper.dpToPx(20),height/5,paintText1);
            }
            //柱子
            canvas.drawRect((i*2+1)*(width/x)+QMUIDisplayHelper.dpToPx(20), height / 5 - Float.parseFloat((value[i] * y) + ""),
                    (i*2+1) * (width / x) + width / x+QMUIDisplayHelper.dpToPx(20), height / 5, paintText);
        }

    }
    public void setDatas(double[] value,int[] date,@Nullable int[]color){
        this.value=value;
        this.date=date;
        this.color=color;
    }
}
