package com.gguoliang.interview.lockDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 11:30 上午
 * @Version 1.0
 *
 * 读写锁使用
 */
public class ReadWriteLockTest {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(myCache.get(temp + ""));
            },String.valueOf(i)).start();
        }

    }

}

class MyCache{
    private volatile Map<String,Object>  cacheMap = new HashMap<>();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     * 写操作使用写锁
     */
    public void put(String key,String value){
        //加写锁
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"线程获取写锁锁成功");
            cacheMap.put(key,value);
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName()+"线程释放获取写锁成功");
        }
    }

    public String get(String key){
        //加读锁
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"线程获取读锁锁成功");
            return cacheMap.get(key).toString();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName()+"线程释放读锁锁成功");
        }
    }

}