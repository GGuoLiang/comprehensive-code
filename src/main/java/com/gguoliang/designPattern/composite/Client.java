package com.gguoliang.designPattern.composite;

/**
 * @Author GGuoLiang
 * @Date 2020/11/8 4:30 下午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        University university = new University("北京大学", "北京大学。。。。。");
        Collage collage1 = new Collage("计算机学院", "计算机。。。。");
        university.add(collage1);
        Collage collage2 = new Collage("信息学院", "信息。。。。。");
        university.add(collage2);
        collage2.add(new Department("通信工程","通信。。。。"));
        collage2.add(new Department("信息工程","信息。。。。"));
        collage1.add(new Department("网络工程","信息。。。。"));
        collage1.add(new Department("计算机","信息。。。。"));
        collage1.add(new Department("软件工程","信息。。。。"));

        university.foreach();
        collage1.foreach();
        collage2.foreach();
    }
}
