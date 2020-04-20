package com.gguoliang.designPattern.singleton.test;

import com.gguoliang.designPattern.singleton.Singleton8;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author GGuoLiang
 * @Date 2020/4/3 12:13 上午
 * @Version 1.0
 */
public class Singleton8Test {

    @Test
    public void test(){
        Singleton8 s1 = Singleton8.INSTANCE;
        Singleton8 s2 = Singleton8.INSTANCE;

        System.out.println(s1 == s2);
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Singleton8> singleton8Class = Singleton8.class;
        Constructor<Singleton8> declaredConstructor = singleton8Class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        System.out.println(declaredConstructor.newInstance());

    }


    @Test
    public void test3() throws IOException {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton8.INSTANCE));
        }

        System.in.read();
    }
}
