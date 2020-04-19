package com.guoliang.designMode.singleton.test;

import com.guoliang.designMode.singleton.Singleton1;
import com.guoliang.designMode.singleton.Singleton4;
import com.guoliang.designMode.singleton.Singleton5;
import com.guoliang.designMode.singleton.Singleton6;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author GGuoLiang
 * @Date 2020/4/2 11:41 下午
 * @Version 1.0
 */
public class Singleton1Test {
    @Test
    public void test() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton1.getInstance())).start();
        }
    }

    @Test
    public void tes2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Singleton1> singleton1Class = Singleton1.class;
        Constructor<Singleton1> declaredConstructor = singleton1Class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton1 singleton1 = declaredConstructor.newInstance();
        Singleton1 instance = Singleton1.getInstance();
        System.out.println(instance == singleton1);
    }


    @Test
    public void test4() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton4.getInstance())).start();
        }
    }

    @Test
    public void test5() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton5.getInstance())).start();
        }
    }

    @Test
    public void test6() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton6.getInstance())).start();
        }
    }

}
