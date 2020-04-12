package com.guoliang.interview.lockDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 8:24 下午
 * @Version 1.0
 *
 * Semaphore 信号灯
 * 可重复利用资源
 *
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 9; i++) {
            new Thread(() ->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"线程获取车位");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"线程释放车位");
                }

            }).start();
        }
    }
}
