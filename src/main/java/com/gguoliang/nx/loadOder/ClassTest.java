package com.gguoliang.nx.loadOder;

import com.gguoliang.entity.Boy;

/**
 * @Author GGuoLiang
 * @Date 2020/12/16 8:37 下午
 * @Version 1.0
 */
public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        /// 4种创建class对象
        Class<Boy> boyClass = Boy.class;
        Boy boy = new Boy();
        Class<? extends Boy> aClass = boy.getClass();
        Class<?> aClass1 = Class.forName("com.gguoliang.entity.Boy");
        Class<?> aClass2 = ClassTest.class.getClassLoader().loadClass("com.gguoliang.entity.Boy");

        if(boyClass.equals(aClass) && aClass.equals(aClass1) && aClass1.equals(aClass2)){
            System.out.println("1");
        }
    }
}
