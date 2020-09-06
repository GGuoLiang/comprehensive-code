package com.gguoliang.java8.stream;

import org.junit.Test;


import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

/**
 * @Author GGuoLiang
 * @Date 2020/9/4 9:56 上午
 * @Version 1.0
 */
public class ParallelStreamTest {

    @Test
    public void test(){
        Integer reduce = Stream.iterate(0, n -> n + 2).limit(10000).reduce(1, Integer::sum);
        // 将顺序流转化为并行流
        Integer reduce1 = Stream.iterate(0, n -> n + 2).limit(10000).parallel().reduce(1, Integer::sum);
        // 将并行流转为顺序流
        Integer reduce2 = Stream.iterate(0, n -> n + 2).limit(10000).parallel().map(integer -> integer + 2).sequential().reduce(1, Integer::sum);
    }

    @Test
    public void test1(){
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(ForkJoinPool.commonPool().getParallelism());
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism","12");
        System.out.println( System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
        System.out.println(ForkJoinPool.commonPool().getParallelism());
    }
}

