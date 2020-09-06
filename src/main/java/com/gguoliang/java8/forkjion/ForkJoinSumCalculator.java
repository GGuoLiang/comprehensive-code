package com.gguoliang.java8.forkjion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @Author GGuoLiang
 * @Date 2020/9/5 6:56 上午
 * @Version 1.0
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    /***
     * 需要计算的数组
     */
    private final long[] numbers;
    /**
     * 子任务的子数组的起始位置
     */
    private final int  start ;
    /**
     * 子任务的子数组的结束位置
     */
    private final int  end;

    /**
     * 分解任务的阈值
     */
    private static final long THRESHOLD = 10_000;

    private ForkJoinSumCalculator(long[] numbers){
        this(numbers,0,numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length =end - start;
        if(length <= THRESHOLD){
            this.computeSequentially();
        }
        ForkJoinSumCalculator leftFork = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftFork.fork();
        ForkJoinSumCalculator rightFork = new ForkJoinSumCalculator(numbers, start+ length / 2, end );
        return leftFork.join()+rightFork.compute();
    }


    private long computeSequentially(){
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }


    public static long forkJoinSum(long n){
        long[] longs = LongStream.rangeClosed(0, n).toArray();
        ForkJoinSumCalculator forkJoinSumCalculator = new ForkJoinSumCalculator(longs);
        return new ForkJoinPool().invoke(forkJoinSumCalculator);
    }

    public static void main(String[] args) {
        //System.out.println(forkJoinSum(10_000));
        System.out.println(1<<8);
    }
}
