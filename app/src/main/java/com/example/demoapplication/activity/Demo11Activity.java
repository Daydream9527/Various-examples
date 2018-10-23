package com.example.demoapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.demoapplication.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Demo11Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo11);
        net1();
//        net2();
    }
        OkHttpClient client = new OkHttpClient();
        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Response response = client.newCall(request).execute();
            return response.body().string();
        }

//        try {
//        JSONArray jsonArray = new JSONArray(json);
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//            if (jsonObject != null) {
//                int id = jsonObject.optInt("id");
//
//                String name = jsonObject.optString("name");
//
//                double price = jsonObject.optDouble("price");
//
//                String imagePath = jsonObject.optString("imagePath");
//
//                // 封装Java对象
//                ShopInfo shopInfo = new ShopInfo(id, name, price, imagePath);
//
//                shops.add(shopInfo);
//            }
//        }
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
    /* get请求方式
     * 请求百度网页的源码数据
     */
    public void net1() {
        //创建网络处理的对象
        OkHttpClient client = new OkHttpClient.Builder()
                //设置读取数据的时间
                .readTimeout(5, TimeUnit.SECONDS)
                //对象的创建
                .build();
        //创建一个网络请求的对象，如果没有写请求方式，默认的是get
        //在请求对象里面传入链接的URL地址
        Request request = new Request.Builder()
                .url("http://gank.io/api/data/Android/10/1").build();

        //call就是我们可以执行的请求类
        Call call = client.newCall(request);
        //异步方法，来执行任务的处理，一般都是使用异步方法执行的
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //失败
                Log.e("TAG",Thread.currentThread().getName() + "结果" + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
                try {
                    JSONObject jsonObject=new JSONObject(str);
                    boolean y=jsonObject.getBoolean("error");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("TAG","d");
            }
        });
    }

    /**
     * post请求方式，请求网络数据
     * 请求ShowAPI里面的json数据
     */
    public void net2() {
        //创建网络处理的对象
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        //post请求来获得数据
        //创建一个RequestBody，存放重要数据的键值对
        RequestBody body = new FormBody.Builder().build();
//                .add("showapi_appid", "13074")
//                .add("showapi_sign", "ea5b4bf2e140498bb772d1bf2a51a7a0").build();
        //创建一个请求对象，传入URL地址和相关数据的键值对的对象
        Request request = new Request.Builder()
                .url("http://gank.io/api/data/Android/10/1")
                .post(body).build();

        //创建一个能处理请求数据的操作类
        Call call = client.newCall(request);

        //使用异步任务的模式请求数据
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","错误信息：" + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG",response.body().string());
                if (response.isSuccessful()){
                    JSONObject jsonObject= null;
//                    try {
//                        jsonObject = new JSONObject(response.body().string());
//                        String showapi_res_error=jsonObject.getString("showapi_res_error");
//                        int i=jsonObject.getInt("showapi_res_code");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
    }

}
