package com.mj.findfriend;

import com.mj.findfriend.net.entity.GirlFriend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huaqiang
 * on 2016-06-02.
 */
public class GirlMain {
    public static List<GirlFriend> list = new ArrayList<GirlFriend>();

    public static int aa=0;
    public static void main(String[] args) throws Exception {
        for (int ag = 0; ag < 6; ag++) {//循环年龄
            for (int he = 0; he < 5; he++) {//循环身高
                for (int we = 0; we < 5; we++) {//循环体重
                    for (int bu = 0; bu < 4; bu++) {//循环胸围
                        for (int co = 0; co < 3; co++) {//循环肤色
                            for (int fs = 0; fs < 3; fs++) {//循环脸型
                                GirlFriend friend = new GirlFriend();
                                friend.setName("aa" + aa);
                                friend.setAge(getAge(ag));
                                friend.setWeight(getWeight(we));
                                friend.setColour(getColour(co));
                                friend.setFaceShape(getFaceShape(fs));
                                friend.setBust(getBust(bu));
                                friend.setHeight(getHeight(he));
                                friend.setPhoto("photo_" + aa);
                                aa++;
                                list.add(friend);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(list);
    }

    //获取年龄
    public static String getAge(int age) {
        if (age == 0) {
            return "17~20";
        } else if (age == 1) {
            return "21~24";
        } else if (age == 2) {
            return "25~28";
        } else if (age == 3) {
            return "29~32";
        } else if (age == 4) {
            return "33~36";
        } else {
            return "37~40";
        }
    }

    //获取身高
    public static String getHeight(int height) {
        if (height == 0) {
            return "156~160";
        } else if (height == 1) {
            return "161~165";
        } else if (height == 2) {
            return "166~170";
        } else if (height == 3) {
            return "171~175";
        } else {
            return "176~180";
        }
    }

    //获取体重
    public static String getWeight(int weight) {
        if (weight == 0) {
            return "46~49";
        } else if (weight == 1) {
            return "50~53";
        } else if (weight == 2) {
            return "54~57";
        } else if (weight == 3) {
            return "58~61";
        } else {
            return "62~65";
        }
    }

    //获取胸围
    public static String getBust(int bust) {
        if (bust == 0) {
            return "34A~34C";
        } else if (bust == 1) {
            return "34D~36A";
        } else if (bust == 2) {
            return "36B~36D";
        } else {
            return "36E~38B";
        }
    }

    //获取肤色
    public static String getColour(int colour) {
        if (colour == 0) {
            return "白";
        } else if (colour == 1) {
            return "黄";
        } else {
            return "黑";
        }
    }

    //获取脸型
    public static String getFaceShape(int faceShape) {
        if (faceShape == 0) {
            return "菱形脸";
        } else if (faceShape == 1) {
            return "长形脸";
        } else {
            return "瓜子脸";
        }
    }

}
