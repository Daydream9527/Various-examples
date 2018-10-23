package com.example.demoapplication.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.demoapplication.R;
import com.example.demoapplication.base.MyApplication;
import com.example.demoapplication.bean.UserBean;
import com.example.demoapplication.greendao.gen.UserBeanDao;
import com.example.demoapplication.permission.PermissionsManager;
import com.example.demoapplication.permission.PermissionsResultAction;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class Demo6Activity extends AppCompatActivity {

    private UserBeanDao testBeanDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions();
        }
        initData();
    }
    private void initData(){
        testBeanDao = MyApplication.getInstances().getDaoSession().getUserBeanDao();
        testBeanDao.deleteAll();
        UserBean userBean=new UserBean(1, "张三", 18, "男");
        UserBean userBean1=new UserBean(2,"李四", 18, "男");
        testBeanDao.insert(userBean);
        testBeanDao.insert(userBean1);
        List<UserBean> users = testBeanDao.loadAll();
        for (int i=0;i<users.size();i++){
            UserBean u=users.get(i);
            if ("张三".equals(users.get(i).getUserName())){
                testBeanDao.delete(u);
            }
        }
        String userName = "";
        for (int i = 0; i < users.size(); i++) {
            userName += users.get(i).getUserName()+",";
        }
        Toast.makeText(this,userName,Toast.LENGTH_SHORT).show();

    }

    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
            }

            @Override
            public void onDenied(String permission) {
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        PermissionsManager.getInstance().notifyPermissionsChange(permissions, grantResults);
    }
}
