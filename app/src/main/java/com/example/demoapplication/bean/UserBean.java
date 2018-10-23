package com.example.demoapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/1/15 0015.
 */
@Entity
public class UserBean {
    @Id(autoincrement = true)
   private long userId;
   private String userName;
   private int age;
   private String sex;
@Generated(hash = 1018946045)
public UserBean(long userId, String userName, int age, String sex) {
    this.userId = userId;
    this.userName = userName;
    this.age = age;
    this.sex = sex;
}
@Generated(hash = 1203313951)
public UserBean() {
}
public long getUserId() {
    return this.userId;
}
public void setUserId(long userId) {
    this.userId = userId;
}
public String getUserName() {
    return this.userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public int getAge() {
    return this.age;
}
public void setAge(int age) {
    this.age = age;
}
public String getSex() {
    return this.sex;
}
public void setSex(String sex) {
    this.sex = sex;
}
}
