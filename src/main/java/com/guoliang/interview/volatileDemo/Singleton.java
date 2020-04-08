package com.guoliang.interview.volatileDemo;

/**
 * @Author GGuoLiang
 * @Date 2020/4/7 11:29 下午
 * @Version 1.0
 *
 * 双检索单列模式
 */
public class Singleton {
    /**
     * 为什么使用的volatile修饰
     * 为了防止指令的重排序
     * singleton = new Singleton(); 可以分为三个操作 1.为对象分配内存空间 2.初始化对象 3.是该对象指向分配的内存空间
     * 由于2和3 操作之间不存在数据依赖性 所以会发生的指令重排的情况
     */
    private static volatile Singleton singleton = null;

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+" init .......");
    }

    /**
     * 在多线程的环境保证线程安全性 使用锁synchronized
     * synchronized 直接修饰方法会的消耗性能 所以最好的使用的双检索机制的修饰代码块
     * @return
     */
    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
