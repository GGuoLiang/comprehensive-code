package com.gguoliang.interview.volatileDemo;

/**
 * @Author GGuoLiang
 * @Date 2020/4/7 11:10 下午
 * @Version 1.0
 *
 * volatile 轻量级的同步机制
 * 1.可见性
 * 2.不保证原子性
 * 3.禁止指令重排
 */
public class Dome1 {
    public static void main(String[] args) {
        MyData1 myData1 = new MyData1();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData1.add1();
                System.out.println(Thread.currentThread().getName()+"修改的值"+myData1.num);
            }
        }).start();

        //当num没有内volatile修饰时 主线程的值会一直处于循环当中
        while (myData1.num == 0){

        }
        System.out.println(Thread.currentThread().getName()+"最终的值"+myData1.num);
    }


}


/**
 * 演示可见性
 */
class MyData1{
    volatile int num = 0;

    public void add1(){
        num++;

    }
}