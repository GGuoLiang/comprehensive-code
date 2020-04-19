package com.gguoliang.interview.lockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author GGuoLiang
 * @Date 2020/4/14 3:04 下午
 * @Version 1.0
 *
 * lock 模式 condition await signalAll
 */
public class LockProductorAndConsumer {
    public static void main(String[] args) {
        Cake cake = new Cake();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                cake.productor();
            }
        },"productor1").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                cake.productor();
            }
        },"productor2").start();


        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                cake.consumer();
            }
        },"consumer1").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                cake.consumer();
            }
        },"consumer2").start();
    }


}


class Cake{

    private volatile int number = 0;

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    /**
     * 生产者
     */
    public void productor(){
        try {
            reentrantLock.lock();
            while (number != 0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"生产后数量"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 消费者
     */
    public void consumer (){
        try {
            reentrantLock.lock();
            while (number == 0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"消费后数量"+number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}