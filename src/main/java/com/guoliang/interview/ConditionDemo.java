package com.guoliang.interview;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author GGuoLiang
 * @Date 2020/4/14 5:07 下午
 * @Version 1.0
 *
 * 使用三个线程实现 A线程打印5次——>B线程打印10->c线程打印15
 */
public class ConditionDemo {

    public static void main(String[] args) throws InterruptedException {
        Print print = new Print();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                print.print5();
            }, "A").start();
            new Thread(() -> {
                print.print10();
            }, "B").start();
            new Thread(() -> {
                print.print15();
            }, "C").start();
        }
    }


}

class Print{

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition conditionA = reentrantLock.newCondition();
    private Condition conditionB = reentrantLock.newCondition();
    private Condition conditionC = reentrantLock.newCondition();


    public void print5(){
        try {
            reentrantLock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            conditionA.await();
            conditionB.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public void print10(){
        try {
            reentrantLock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            conditionB.await();
            conditionA.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public void print15(){
        try {
            reentrantLock.lock();
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            conditionC.await();
            conditionA.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }
}