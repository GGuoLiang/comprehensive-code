package com.guoliang.designMode.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/3/24 9:32 上午
 * @Version 1.0
 *
 * 加锁版的 懒汉式 线程不安全 反射不安全
 *
 */
public class Singleton6 {
    private static  volatile  Singleton6 instance;

    private Singleton6() {
    }

    public static synchronized Singleton6 getInstance() {
        if (instance == null) {
            instance = new Singleton6();
        }
        return instance;
    }

}
