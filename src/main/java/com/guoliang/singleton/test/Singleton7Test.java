package com.guoliang.singleton.test;

import com.guoliang.singleton.Singleton7;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author GGuoLiang
 * @Date 2020/4/3 12:03 上午
 * @Version 1.0
 */
public class Singleton7Test {

    @Test
    public void test1(){
        Singleton7 s1 = Singleton7.getInstance();
        Singleton7 s2 = Singleton7.getInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test2() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton7.getInstance())).start();
        }

    }

    @Test
    private void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Singleton7> singleton7Class = Singleton7.class;
        Constructor<Singleton7> declaredConstructor = singleton7Class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton7 singleton7 = declaredConstructor.newInstance();
        Singleton7 singleton71 = Singleton7.getInstance();
        System.out.println(singleton7 == singleton71);
    }
}
