package com.gguoliang.interview.casDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author GGuoLiang
 * @Date 2020/4/9 10:49 上午
 * @Version 1.0
 *
 * cas 遇到的ABA问题
 */
public class CasABATest {


    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);
        new Thread(() -> {
            atomicInteger.getAndDecrement();
            System.out.println("第一次修改"+atomicInteger.get());
            atomicInteger.getAndDecrement();
            System.out.println("第二次修改"+atomicInteger.get());
        }).start();


        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.getAndDecrement();
            System.out.println("第三次次修改"+atomicInteger.get());
        }).start();

    }
}
