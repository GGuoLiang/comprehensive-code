package com.guoliang.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/3/24 9:32 上午
 * @Version 1.0
 *
 * 懒汉式 线程不安全 反射不安全
 *
 */
public class Singleton1 {
    private static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

}
