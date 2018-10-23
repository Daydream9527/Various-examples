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


/**
 * 柱状统计图
 * create by dayDream
 * 2018/10/23
 */
public class MyChartView extends View {

    private Paint paint;
    private Context mContext;
    private Path path;
    private int width;
//    private int height;

    private double[] value = {0f, 0f, 0f, 0f, 0f, 0f, 0f};
    private int[] date = {0, 0, 0, 0, 0, 0, 0};

    public MyChartView(Context context) {
        super(context);
        init();
    }

    public MyChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    public MyChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private void init(){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;         // 屏幕宽度（像素）
//        height = dm.heightPixels;       // 屏幕高度（像素）

        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.white)); //画笔颜色
        paint.setStyle(Paint.Style.STROKE); //这里是设置填充模式还是画线
        paint.setStrokeWidth(3);  //这里是设置线条的宽度
        paint.setAntiAlias(true); //这里是设置抗锯齿
        paint.setTextSize(28);   //这里是设置字体大小

        //统计图的框架
        path=new Path();
        path.rMoveTo(50,420);//不显示y轴
        //显示y轴
//        path.rMoveTo(50,20);
//        path.lineTo(50,420);
        path.rLineTo(width-100,0);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paintText=new Paint();
        paintText.setColor(getResources().getColor(R.color.white)); //画笔颜色
        paintText.setStyle(Paint.Style.FILL); //这里是设置填充模式还是画线
        paintText.setStrokeWidth(1);  //这里是设置线条的宽度
        paintText.setAntiAlias(true); //这里是设置抗锯齿
        paintText.setTextSize(40);   //这里是设置字体大小
        canvas.drawPath(path,paint);
        //x轴上的点
        Paint paintText1=new Paint();
        paintText1.setColor(getResources().getColor(R.color.white)); //画笔颜色
        paintText1.setStrokeWidth(10);

        double y=0; //y轴的平均值
        double num=0; //y轴上最大的值
        for (int i=0;i<value.length;i++){
            if (num<value[i]){
                num=value[i];
            }
        }
        y=380/num;
        //设置横轴的个数为7
        for (int i=0;i<7;i++){
            //X轴的值
            canvas.drawText(date[i]+"",i*(width/8)+90,460,paintText);
            //柱子
            canvas.drawRect(i*(width/8)+90, 420-Float.parseFloat((value[i]*y)+""),
                    i*(width/8)+150, 420, paintText);
            //x轴上的点
            canvas.drawPoint(i*(width/8)+120,420,paintText1);
            //y轴的值
            canvas.drawText("￥"+value[i],i*(width/8)+80,420-Float.parseFloat((value[i]*y)+"")-10, paint);
        }

    }
    public void setDatas(double[] value,int[] date){
           this.value=value;
           this.date=date;
    }
}
