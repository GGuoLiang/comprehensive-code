package com.gguoliang.interview.lockDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 8:12 下午
 * @Version 1.0
 *
 * CyclicBarrier 增加
 *
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("开始召唤神龙。。。。。");
        });
        for (int i = 0; i < 8; i++) {
            final int temp = i;
            new Thread(() ->{
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"线程   "+temp+"号龙珠收集成功。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
