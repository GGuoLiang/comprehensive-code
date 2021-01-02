package com.gguoliang.juc.thread;

import lombok.Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/11/30 9:53 下午
 * @Version 1.0
 */
public class WaitNotifTest {

    public static void main(String[] args) {
        final  String str = "aaa";

        new Thread(() -> {
            mothed1(str);
        }).start();

        new Thread(() -> {
            mothed2(str);
        }).start();


    }

    public static void mothed1(String  str){

            try {
                System.out.println("111111111");
                TimeUnit.SECONDS.sleep(1);
                str.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();

        }
        str.notify();

    }

    public static void mothed2(String  str){

            try {
                System.out.println("222222222");
                TimeUnit.SECONDS.sleep(1);
                str.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        str.notify();

    }

}
