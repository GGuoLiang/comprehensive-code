package com.guoliang.designMode.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/4/2 10:58 下午
 * @Version 1.0
 *
 * 饿汉式 线程安全的 反序列化不安全 反射不安全
 */
public class Singleton2 {

    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2(){

    }

    public static Singleton2 getInstance(){
        return singleton2;
    }

    /**
     * 可以解决的反序列化对象不安全的问题
     *
     * 由于singleton2 是一个静态的变量的 在序列化的过程中不会被保存
     * 当他在反序列化的时候会创建的一个新的对象
     * 添加readResolve 可以在反序列化的时候不在创建，直接根据该方法返回实例
     * @return
     */
    private Object readResolve(){
        return singleton2;
    }

}
