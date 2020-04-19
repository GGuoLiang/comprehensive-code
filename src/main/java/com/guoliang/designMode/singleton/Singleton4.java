package com.guoliang.designMode.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/3/24 9:32 上午
 * @Version 1.0
 *
 * 加锁版的 懒汉式 线程不安全 反射不安全
 *
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }

}
