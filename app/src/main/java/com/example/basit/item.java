package com.example.basit;

public class item {

    String text1;
    String text2;
    int imgRes= NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;


    public item(String a, String b) {text1=a ; text2=b; }
    public item(String a, String b, int img) {text1=a; text2=b; imgRes=img; }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public int getImgRes() {
        return imgRes;
    }

    public boolean hasImg() {
        return imgRes != NO_IMAGE_PROVIDED;
    }
}
