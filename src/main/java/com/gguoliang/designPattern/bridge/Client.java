package com.gguoliang.designPattern.bridge;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 4:36 下午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        Phone phone = new FoldPhone();
        phone.setBrand(new Huawei());
        phone.call("张三");
    }
}
