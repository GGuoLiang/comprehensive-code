package com.guoliang.interview.lockDemo;

import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author GGuoLiang
 * @Date 2020/4/15 2:22 下午
 * @Version 1.0
 *
 * 相互持有资源
 *
 * jps -l
 * jstack -进程编号
 */
public class DeadLocKTest {
    public static void main(String[] args) {
       /* DeadLocK deadLocK = new DeadLocK();
        new Thread(()->{
            deadLocK.deadLocKA();
        },"AA").start();

        new Thread(()->{
            deadLocK.deadLocKB();
        },"BB").start();*/
       String lock1 = "lock1";
       String lock2 = "lock2";
       new Thread(new DeadSync(lock1,lock2),"AA").start();
       new Thread(new DeadSync(lock2,lock1),"BB").start();
    }

}

/**
 * 资源类
 */
class DeadLocK{

    private ReentrantLock reentrantLockA = new ReentrantLock();

    private ReentrantLock reentrantLockB = new ReentrantLock();

    public void deadLocKA(){
        reentrantLockA.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"AA1");
            try {
                TimeUnit.SECONDS.sleep(1);
                reentrantLockB.lock();
                System.out.println(Thread.currentThread().getName()+"AA2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLockB.unlock();
            }
        }finally {
            reentrantLockA.unlock();
        }
    }

    public void deadLocKB(){
        reentrantLockB.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"BB1");
            try {
                TimeUnit.SECONDS.sleep(1);
                reentrantLockA.lock();
                System.out.println(Thread.currentThread().getName()+"BB2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLockA.unlock();
            }
        }finally {
            reentrantLockB.unlock();
        }
    }

}

@Data
class  DeadSync implements Runnable {
    private String lock1;
    private String lock2;

    public DeadSync(String lock1, String lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public  void run(){
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName()+lock1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName()+lock2);
            }
        }
    }
}