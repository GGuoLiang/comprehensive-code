package com.gguoliang.designPattern.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/3/24 9:32 上午
 * @Version 1.0
 *
 * 加锁版的 懒汉式 线程不安全 反射不安全
 *
 * new 对象指令重排  1.分派对象内存空间， 2 指向分派的内存空间 3.初始化对象
 *
 */
public class Singleton5 {
    private static volatile Singleton5 instance;

    private Singleton5() {
    }

    public static  Singleton5 getInstance() {
        if (instance == null) {
            synchronized(Singleton5.class){
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
