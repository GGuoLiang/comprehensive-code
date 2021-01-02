package com.gguoliang.nx;

import com.gguoliang.entity.Boy;

/**
 * @Author GGuoLiang
 * @Date 2020/12/15 9:53 下午
 * @Version 1.0
 */
public class Clazz {

    public static void main(String[] args) throws ClassNotFoundException {
        Boy boy1 = new Boy();
        long l = System.currentTimeMillis();
        Class<Boy> aClass = (Class<Boy>) Class.forName("com.gguoliang.entity.Boy");
        try {
            Boy boy = aClass.newInstance();
            System.out.println(System.currentTimeMillis()-l);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
