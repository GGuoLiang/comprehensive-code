package com.gguoliang.interview.lockDemo;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 10:38 上午
 * @Version 1.0
 *
 * 可重入的锁性能测试
 *  Person synchronized
 *  Student lock
 *
 *  俩者区别
 * 1.原始构成：sync是JVM层面的，底层通过monitorenter和monitorexit来实现的。Lock是JDK API层面的。（sync一个enter会有两个exit，一个是正常退出，一个是异常退出）
 * 2.使用方法：sync不需要手动释放锁，而Lock需要手动释放。
 * 3.是否可中断：sync不可中断，除非抛出异常或者正常运行完成。Lock是可中断的，通过调用interrupt()方法。
 * 4.是否为公平锁：sync只能是非公平锁，而Lock既能是公平锁，又能是非公平锁。
 * 5.绑定多个条件：sync不能，只能随机唤醒。而Lock可以通过Condition来绑定多个条件，精确唤醒。
 *
 *
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person();
        new Thread(() -> {
            person.set("线程AA设置的值");
        },"AA").start();

        new Thread(() -> {
            person.set("线程AA设置的值");
        },"BB").start();

        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" 方法执行完毕......");

        new Thread(new Student("线程3"),"cc").start();
        new Thread(new Student("线程4"),"dd").start();
    }


}


@Data
class Person  {
    private String name;

    public synchronized void set(String name){
        System.out.println(Thread.currentThread().getName()+" set方法执行......"+" name:"+name);
        this.get();
    }

    public synchronized void get(){
        System.out.println(Thread.currentThread().getName()+" get方法执行......");
    }

}

@Data
class Student implements Runnable{
    private String name;

    public Student(String name){
        this.name = name;
    }

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        this.set(name);
    }

    private void set(String name){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" set方法执行......"+" name:"+name);
            this.get();
        }finally {
            lock.unlock();
        }
    }

    public  void get(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+" get方法执行......");
        }finally {
            lock.unlock();
        }

    }


}