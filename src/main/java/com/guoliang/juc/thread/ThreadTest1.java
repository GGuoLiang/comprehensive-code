package com.guoliang.juc.thread;


/**
 *  JDK1.5之前创建新执行线程有两种方法:
 *   继承Thread类的方式
 *   实现Runnable接口的方式
 */
public class ThreadTest1 {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread().getName()+" main ............");

        new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName()+" new Thread 。。。。。。。。");
            }

        }.start();
    }

}

/**
 *
 * 继承Thread类创建创建线程
 *
 * 1.定义子类继承Thread类。
 * 2.子类中重写Thread类中的run方法。
 * 3.创建Thread子类对象，即创建了线程对象。
 * 4.调用线程对象start方法:启动线程，调用run方法。
 */
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+" mythread .........");
    }


}
