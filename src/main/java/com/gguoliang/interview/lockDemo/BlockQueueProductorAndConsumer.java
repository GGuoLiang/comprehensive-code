package com.gguoliang.interview.lockDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author GGuoLiang
 * @Date 2020/4/14 3:50 下午
 * @Version 1.0
 *
 * 阻塞队列生产和消费者模式
 * 注意：传参传接口
 *
 */
public class BlockQueueProductorAndConsumer {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(3));
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResource.productor();
            }
        }, "productor").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResource.consumer();
            }
        }, "consumer1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResource.consumer();
            }
        }, "consumer2").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResource.consumer();
            }
        }, "consumer3").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                myResource.consumer();
            }
        }, "consumer4").start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myResource.stop();

    }

}

class MyResource{

    protected volatile Boolean flag = true;
    private BlockingQueue<String> blockingQueue;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产者
     */
    public void productor(){
        while (flag){
            atomicInteger.getAndIncrement();
            try {
                if(blockingQueue.offer(atomicInteger+"",1L, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()+"线程生产成功");
                }else{
                    System.out.println(Thread.currentThread().getName()+"线程生产失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费者
     */
    public void consumer(){
        String poll = null;
        try {
          while (flag){
               poll = blockingQueue.poll(1L, TimeUnit.SECONDS);
              if(poll != null){
                  System.out.println(Thread.currentThread().getName()+"线程消费成功 "+poll);
              }else{
                  System.out.println(Thread.currentThread().getName()+"线程消费失败 ");
                  flag = false;
              }
          }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void stop(){
        flag = false;
        System.out.println(Thread.currentThread().getName()+"线程叫停！！！！");
    }
}

