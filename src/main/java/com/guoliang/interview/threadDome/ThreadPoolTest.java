package com.guoliang.interview.threadDome;


import java.sql.SQLOutput;
import java.util.concurrent.*;

/**
 * @Author GGuoLiang
 * @Date 2020/4/15 10:19 上午
 * @Version 1.0
 * 
 * 创建线程的第四种方式 线程池
 * Executor→ExecutorService→AbstractExecutorService→ThreadPoolExecutor。ThreadPoolExecutor是线程池创建的核心类。
 * 类似Arrays、Collections工具类，Executor也有自己的工具类Executors。
 *
 * Executors 创建线程的方式
 * newFixedThreadPool 一池多个线程（参数值） 阻塞队列使用的LinkedBlockingQueue（无限大的队列 造成OOM）、
 * newSingleThreadExecutor 一池1个线程（参数值）阻塞队列使用的LinkedBlockingQueue（无限大的队列 造成OOM）、
 *
 * newScheduledThreadPool 一池多个核心线程（参数值） 线程最大数量 maximumPoolSize（无线大）
 * newCachedThreadPool 一池0个核心线程 （参数值）线程最大数量 maximumPoolSize（无线大）
 *
 * 该四种方式会造成OOM 所部不建议使用 应该根据实际情况手动创建数量
 *
 * 手动创建线程池  七个参数 核心线程数 最大线程数量 线程空闲存活时间 时间单位 阻塞队列 线层工厂 拒绝策略
 *
 * 拒绝策略： 报异常(默认) 当前提交线程处理 丢弃最早的等待任务  丢弃当前提交的任务
 *
 * 对于CPU密集型任务(使用计算多一点的)，最大线程数是CPU线程数+1。
 * 对于IO密集型任务，尽量多配点，可以是CPU线程数*2，或者CPU线程数/(1-阻塞系数)。
 * 
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * 获取cpu核数
         */
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        for (int i = 0; i < 8; i++) {
            FutureTask futureTask = new FutureTask(new CallableThread());
            threadPoolExecutor.submit(futureTask);
            System.out.println(futureTask.get());


        }
        threadPoolExecutor.shutdown();

    }
}
