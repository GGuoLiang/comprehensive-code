package com.gguoliang.idea;

/**
 * @Author GGuoLiang
 * @Date 2020/12/4 2:55 下午
 * @Version 1.0
 */
public class debugTest {


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()-> mothod1()).start();
        }

    }


    public static void  mothod1(){

        System.out.println(Thread.currentThread().getName() + "llllllll");
    }
}
