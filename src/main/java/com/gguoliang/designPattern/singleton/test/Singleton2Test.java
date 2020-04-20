package com.gguoliang.designPattern.singleton.test;

import com.gguoliang.designPattern.singleton.Singleton2;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author GGuoLiang
 * @Date 2020/4/2 11:00 下午
 * @Version 1.0
 *
 */
public class Singleton2Test {


    /**
     * 线程安全
     */
    @Test
    public void  test1(){
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton2 s1 = Singleton2.getInstance();
                    System.out.println(s1);
                }
            }).start();
        }
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Singleton2.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton2 s1 = (Singleton2)constructor.newInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);

    }
}
