package com.guoliang.interview.lockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 10:57 上午
 * @Version 1.0
 *
 * 手写一个自旋锁
 * compareAndSet 获取锁和释放都是用
 *
 *
 */
public class MySpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"线程lock方法come in 。。。。。。。");
        while (!atomicReference.compareAndSet(null,thread)){
            System.out.println(thread.getName()+"获取锁失败。。。。。");
        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"线程unlock方法come in 。。。。。。。");
        while (!atomicReference.compareAndSet(thread,null)){
            System.out.println(thread.getName()+"释放锁失败。。。。。");
        }
    }


    public static void main(String[] args) {
        MySpinLock mySpinLock = new MySpinLock();
        new Thread(() ->{
            try {
                mySpinLock.lock();
                System.out.println(Thread.currentThread().getName()+"线程获取锁。。。。。。");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mySpinLock.unlock();
            }
        },"aa").start();

        new Thread(() ->{
            try {
                mySpinLock.lock();
                System.out.println(Thread.currentThread().getName()+"线程获取锁。。。。。。");
            }  finally {
                mySpinLock.unlock();
            }
        },"bb").start();
    }


}
