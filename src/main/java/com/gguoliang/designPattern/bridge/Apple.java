package com.gguoliang.designPattern.bridge;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 4:33 下午
 * @Version 1.0
 */
public class Apple implements Brand {
    @Override
    public String call(String name) {
        System.out.println("Apple 手机 call"+name);
        return "Apple";
    }
}
