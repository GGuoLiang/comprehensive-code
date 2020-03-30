package com.guoliang.test;

import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/3/27 11:22 上午
 * @Version 1.0
 */
public class LongTest {

    @Test
    public void test(){
        Long a = 33333L;
        System.out.println("33333".equals(String.valueOf(a)));
        System.out.println(a == 33333);
        int b = 33333;
        System.out.println(b==a);
        System.out.println(a.equals(b));



    }
}
