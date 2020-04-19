package com.gguoliang.interview.lockDemo;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 1:39 下午
 * @Version 1.0
 *
 * CountDownLatch 倒计时
 *
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"线程结束。。。。。");
                countDownLatch.countDown();
                System.out.println("countDownLatch当前值："+countDownLatch.getCount());
            },EnumDemo.getNameById(temp).name).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"线程结束。。。。。");
    }



    static enum EnumDemo{
        enum1(1,"enum1"),
        enum2(2,"enum2"),
        enum3(3,"enum3"),
        enum4(4,"enum4"),
        enum5(5,"enum5");

        @Getter
        @Setter
        private int id;
        @Getter
        @Setter
        private String name;

        EnumDemo(int id,String name){
            this.id= id;
            this.name = name;
        }

        public static EnumDemo getNameById(int id){
            EnumDemo[] values = EnumDemo.values();
            for (EnumDemo value : values) {
                if(value.getId() == id){
                    return value;
                }
            }
            return null;
        }


    }
}


