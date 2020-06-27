package com.example.basit;

public class item {

    String text1;
    String text2;
    int imgRes= NO_IMAGE_PROVIDED;
    int musicSource;
    private static final int NO_IMAGE_PROVIDED = -1;


    public item(String a, String b , int music) {text1=a ; text2=b; musicSource=music; }
    public item(String a, String b, int img, int music) {text1=a; text2=b; imgRes=img; musicSource=music;}

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public int getImgRes() {
        return imgRes;
    }

    public int getMusicSource() { return musicSource; }

    public boolean hasImg() {
        return imgRes != NO_IMAGE_PROVIDED;
    }
}
