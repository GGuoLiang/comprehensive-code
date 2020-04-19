package com.gguoliang.interview.threadDome;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/4/14 10:41 上午
 * @Version 1.0
 *
 * 线程创建方式 四种方式 继承 实现Runnable 实现callable 线程池
 *
 * Callable方式
 *
 * new Thread() 参数需要实现Runnable接口
 * FutureTask 实现RunnableFuture接口 实现RunnableFuture接口继承Runnable
 * new FutureTask()参数实现Callable接口
 * 所以创建线程的第三种方法 实现Callbale 借助 FutureTask类 异步返回结果futureTask.get()
 *
 * 注：futureTask.get()一般方法代码执行最后  不然会出现阻塞main线程情况
 *
 *
 */
public class CallbaleTest {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask(new CallableThread());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class CallableThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return Thread.currentThread().getName()+"hello world";
    }
}
