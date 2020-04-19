package com.guoliang.designMode.singleton.test;

import com.guoliang.designMode.singleton.Singleton3;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author GGuoLiang
 * @Date 2020/4/2 11:23 下午
 * @Version 1.0
 */
public class Singleton3Test {

    @Test
    public void test1(){
        try {
            Class.forName("com.guoliang.designMode.singleton.Singleton3");
            Singleton3.getInstance();

        }catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("_______________________");
        Singleton3 s1 = Singleton3.getInstance();
        Singleton3 s2 = Singleton3.getInstance();
        System.out.println(s1 == s2);
    }

    @Test
    public void test2(){
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(Singleton3.getInstance())).start();
        }
    }

    @Test
    public void Test3(){
        try {
            Class clazz = Singleton3.class;
            Constructor declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Singleton3 s1 = (Singleton3) declaredConstructor.newInstance();
            Singleton3 s2 = Singleton3.getInstance();
            System.out.println(s1 == s2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
