package com.gguoliang.designPattern.adapter.interfaceadapter;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 4:06 下午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void motheda() {
                System.out.println("ceh测试");
            }
        };
        absAdapter.motheda();
    }
}
