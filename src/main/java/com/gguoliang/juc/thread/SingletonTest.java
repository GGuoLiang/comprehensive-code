package com.gguoliang.juc.thread;

/**
 * 线程安全的单例设计模式 -懒汉式
 *
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);
    }
}


class Singleton{

    private static Singleton singleton = null;

    private Singleton(){

    }

    public static Singleton getInstance(){
        synchronized (Singleton.class){
            if(singleton == null){
                singleton = new Singleton();
            }
        }
        return singleton;
    }

}