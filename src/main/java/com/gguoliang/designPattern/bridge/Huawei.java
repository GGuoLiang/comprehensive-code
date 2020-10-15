package com.gguoliang.designPattern.bridge;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 4:32 下午
 * @Version 1.0
 */
public class Huawei implements Brand{
    @Override
    public String call(String name) {
        System.out.println("huawei 手机 call"+name);
        return "huawei";
    }
}
