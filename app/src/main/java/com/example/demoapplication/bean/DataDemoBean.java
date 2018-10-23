package com.example.demoapplication.bean;


public class DataDemoBean {
    private String title;
    private String words;
    private String picture;

    public DataDemoBean() {

    }

    public DataDemoBean(String title, String words, String picture) {
        this.title = title;
        this.words = words;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
