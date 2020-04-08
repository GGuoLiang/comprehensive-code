package com.guoliang.interview.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author GGuoLiang
 * @Date 2020/4/7 11:19 下午
 * @Version 1.0
 *
 * 原子性：保证的一个操作中间不可有存在分割或者加塞情况，要么都成工程 要么都失败
 *
 *
 */
public class Dome2 {

    /**
     * 测试被volatile修饰的不保证原子性
     * 会出的漏算的情况
     *
     * 解决办法：
     *  1.synchronized
     *  2. Atomic
     * @param args
     */
    public static void main(String[] args) {
        MyData1 myData1 = new MyData1();
        MyData2 myData2 = new MyData2();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        myData1.add1();
                        myData2.add1();
                    }

                }
            }).start();
        }

        /**
         * 保证的上面的线程已经全部运行完成
         */
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(myData1.num);
        System.out.println(myData2.atomicInteger);
    }


}


/**
 * 保证的原子性的方法之一
 */
class MyData2{
    AtomicInteger atomicInteger = new AtomicInteger();
    public void add1(){
        atomicInteger.getAndIncrement();

    }
}