package com.guoliang.interview.blockQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/4/12 8:57 下午
 * @Version 1.0
 *
 * Collection -> Queue - >BlockingQueue ->实现类
 * 实现类：
 * ArrayBlockingQueue	由数组构成的有界阻塞队列
 * LinkedBlockingQueue	由链表构成的有界阻塞队列
 * PriorityBlockingQueue	支持优先级排序的无界阻塞队列
 * DelayQueue	支持优先级的延迟无界阻塞队列
 * SynchronousQueue	单个元素的阻塞队列
 * LinkedTransferQueue	由链表构成的无界阻塞队列
 * LinkedBlockingDeque	由链表构成的双向阻塞队列
 *
 * BlockingQueue方法
 * 报异常： add remove element
 * 返回Boolean offer poll  peek
 * 阻塞：put take
 * 超时：offer poll
 */
public class BlockQueueTest {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(12);
        BlockingQueue<String> blockingQueue1 = new SynchronousQueue();
       /* for (int i = 0; i < 12; i++) {
            System.out.println(blockingQueue.add(i + ""));
        }
        for (int i = 0; i < 15; i++) {
            System.out.println(blockingQueue.element());
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(blockingQueue.remove());
        }*/

        new Thread(()->{
            for (int i = 0; i < 15; i++) {
                try {
                    System.out.println(i+"添加成功。。。。。。。");
                    blockingQueue1.put(i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //TimeUnit.SECONDS.sleep(3);
        new Thread(()->{
            for (int i = 0; i < 15; i++) {
                try {
                    System.out.println(blockingQueue1.take()+"取出");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
