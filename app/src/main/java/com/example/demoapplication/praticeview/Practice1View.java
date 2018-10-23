package com.example.demoapplication.praticeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import com.example.demoapplication.R;

/**
 * Created by Administrator on 2018/2/12 0012.
 */

public class Practice1View extends View{

    private Paint paint;
    private Context mContext;
    private Path path;

    public Practice1View(Context context) {
        super(context);
        init();
    }

    public Practice1View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        init();
    }

    public Practice1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Practice1View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    private void init(){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        int height = dm.heightPixels;       // 屏幕高度（像素）
        float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
        // 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        int screenWidth = (int) (width / density);  // 屏幕宽度(dp)
        int screenHeight = (int) (height / density);// 屏幕高度(dp)

        
        paint=new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent)); //画笔颜色
        paint.setStyle(Paint.Style.FILL); //这里是设置填充模式还是画线
        paint.setStrokeWidth(1);  //这里是设置线条的宽度
        paint.setAntiAlias(true); //这里是设置抗锯齿
        paint.setTextSize(20);   //这里是设置字体大小
        //渐变的圆
//        Shader shader=new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
//                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
//        paint.setShader(shader);
        //路径
//        path=new Path();
//        path.addCircle(100,100,50,Path.Direction.CW); //这里是添加一个圆
//        path.lineTo(200,200);  //从0，0 到 200，200 画线
//        path.rLineTo(200,0);  //从上次结束的点到200，0画线
//        path.close();     //使画的线连接起来  封闭
//        path.rMoveTo(200,0); //移动起点到这个地方
//        path.rLineTo(0,200);
//        path.arcTo(200, 200, 400, 400,
//                -90, 90, true); //画弧线  boolean代表是否连线
//          path.addCircle(150,100,50,Path.Direction.CW);

        //统计图的框架
//        path.rMoveTo(20,20);
//        path.lineTo(20,420);
//        path.rLineTo(width-100,0);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
//        canvas.drawColor(getResources().getColor(R.color.app_color));
//        canvas.drawCircle(300,300,200,paint); //画圆
//        canvas.drawRect(100,100,300,300,paint);  //画矩形
//        canvas.drawRoundRect(100,100,300,300,20,20,paint); //这里画的是边角是圆的矩形
//        canvas.drawLine(100,100,300,350,paint);//这里是画线
//        canvas.drawOval(100,100,300,200,paint); //这里是画椭圆

        //sweepAngle是划过的弧度 顺时针为正 逆时针为负
        canvas.drawArc(100,100,200,200,
                0,-90,true,paint);//这里是扇形（连接到圆心）
//        canvas.drawArc(100,100,200,200,
//                -130,90,false,paint);//这里是弧形（不连接到圆心）
//          canvas.drawPath(path,paint);//这里是用path画
//        canvas.drawText("测试",100,450,paint); //文字
//        paint.setColor(getResources().getColor(R.color.app_color));

        //这里是柱状统计图
//        Paint paint1=new Paint();
//        paint1.setStyle(Paint.Style.FILL);
//        paint1.setColor(getResources().getColor(R.color.colorAccent)); //画笔颜色
//        Path path1=new Path();
//        path1.addRect(50, 50, 80, 420, Path.Direction.CW);
//        path1.addRect(100, 60, 130, 420, Path.Direction.CW);
//        path1.addRect(150, 80, 180, 420, Path.Direction.CW);
//        path1.addRect(200, 40, 230, 420, Path.Direction.CW);
//        canvas.drawPath(path1,paint1);//这里是用path画  如果这里不使用新建的path和paint 将会出现bug

        //这里是折线统计图
//        Paint paint1=new Paint();
//        paint1.setStyle(Paint.Style.STROKE);
//        paint1.setStrokeWidth(3);
//        paint1.setColor(getResources().getColor(R.color.app_color)); //画笔颜色
//        Path path1=new Path();
//        path1.rMoveTo(20,420);
//        path1.lineTo(25,380);
//        path1.rLineTo(30,0);
//        canvas.drawPath(path1,paint1);
//
//        paint1.setStrokeWidth(10);
//        paint1.setStrokeCap(Paint.Cap.ROUND);  //圆的还是方的 23333
//        float[] points = { 20, 420, 25, 380,55, 380};
//       // 绘制四个点：(50, 50) (50, 100) (100, 50) (100, 100)
//        canvas.drawPoints(points, 0 /* 跳过两个数，即前两个 0 */,
//                3 /* 一共绘制 8 个数（4 个点）*/, paint1);

        //这里是饼状统计图
//        canvas.drawArc(100,100,400,400,
//                -130,90,true,paint);//这里是扇形（连接到圆心）
//
//        paint.setColor(getResources().getColor(R.color.app_color));
//        canvas.drawArc(100,100,400,400,
//                -45,120,true,paint);//这里是扇形（连接到圆心）
//
//        paint.setColor(getResources().getColor(R.color.colorPrimary));
//        canvas.drawArc(80,110,380,410,
//                90,140,true,paint);//这里是扇形（连接到圆心）
//
//        paint.setColor(getResources().getColor(R.color.colorAccent)); //画笔颜色
//        canvas.drawArc(100,100,400,400,
//                75,15,true,paint);//这里是扇形（连接到圆心）

//        canvas.drawCircle(200,200,100,paint);
    }
}
