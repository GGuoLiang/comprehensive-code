package com.gguoliang.juc.thread;

/**
 *实现Runnable接口
 *
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
        System.out.println(" main ............");
    }

}

/**
 * 1. 定义子类，实现Runnable接口。
 * 2. 子类中重写Runnable接口中的run方法。
 * 3. 通过Thread类含参构造器创建线程对象。
 * 4. 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
 * 5. 调用Thread类的start方法:开启线程，调用Runnable子类接口的run方法。
 */
 class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread2 ............... ");
    }
}