package com.guoliang.designMode.singleton;

/**
 * @Author GGuoLiang
 * @Date 2020/4/2 11:58 下午
 * @Version 1.0
 *
 * ThreadLocal
 */
public class Singleton7 {

    private static Singleton7 singleton7 = null;

    private Singleton7(){

    }

    private static final ThreadLocal<Singleton7> singleton7ThreadLocal = new ThreadLocal<Singleton7>(){
        @Override
        protected Singleton7 initialValue(){
           return new Singleton7();
        }
    };

    public static Singleton7 getInstance(){
        return singleton7ThreadLocal.get();

    }
}
