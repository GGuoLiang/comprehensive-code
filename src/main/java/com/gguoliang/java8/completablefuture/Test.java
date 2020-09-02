package com.gguoliang.java8.completablefuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author GGuoLiang
 * @Date 2020/9/1 6:56 上午
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void Test1(){
        List<Shop> shops = Arrays.asList(
                new Shop("shop1"), new Shop("shop2"),
                new Shop("shop3"), new Shop("shop4"),
                new Shop("shop5"), new Shop("shop6"));

        long l = System.nanoTime();
        List<Double> aplle = shops.stream().map(shop -> shop.calculatePrice("aplle")).collect(Collectors.toList());
        System.out.println((System.nanoTime() - l)/1_00_000);
    }


    @org.junit.Test
    public void Test2(){
        List<Shop> shops = Arrays.asList(
                new Shop("shop1"), new Shop("shop2"),
                new Shop("shop3"), new Shop("shop4"),
                new Shop("shop5"), new Shop("shop6"));

        long l = System.nanoTime();
        List<Double> aplle = shops.parallelStream().map(shop -> shop.calculatePrice("aplle")).collect(Collectors.toList());
        System.out.println((System.nanoTime() - l)/1_00_000);
    }

    @org.junit.Test
    public void Test3(){
        List<Shop> shops = Arrays.asList(
                new Shop("shop1"), new Shop("shop2"),
                new Shop("shop3"), new Shop("shop4"),
                new Shop("shop5"), new Shop("shop6"));

        long l = System.nanoTime();

        List<CompletableFuture<Double>> apple = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.calculatePrice("apple"))).collect(Collectors.toList());
        Stream<Double> doubleStream = apple.stream().map(CompletableFuture::join);
        System.out.println((System.nanoTime() - l)/1_00_000);
    }

    @org.junit.Test
    public void Test4(){
        List<Shop> shops = Arrays.asList(
                new Shop("shop1"), new Shop("shop2"),
                new Shop("shop3"), new Shop("shop4"),
                new Shop("shop5"), new Shop("shop6"));

        long l = System.nanoTime();
        List<Double> apple = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.calculatePrice("apple"))).map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println((System.nanoTime() - l)/1_00_000);
    }

    @org.junit.Test
    public void Test5(){
        List<Shop> shops = Arrays.asList(
                new Shop("shop1"), new Shop("shop2"),
                new Shop("shop3"), new Shop("shop4"),
                new Shop("shop5"), new Shop("shop6"));
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(shops.size(),100));
        long l = System.nanoTime();
        List<Double> apple = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.calculatePrice("apple"),executorService)).map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println((System.nanoTime() - l)/1_00_000);

    }

    @org.junit.Test
    public void Test6(){
        List<Shop> shops = Arrays.asList(
                new Shop("shop1"), new Shop("shop2"),
                new Shop("shop3"), new Shop("shop4"),
                new Shop("shop5"), new Shop("shop6"));

        long l = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(shops.size(),100));
        List<CompletableFuture<Double>> apple = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.calculatePrice("apple"),executorService)).collect(Collectors.toList());
        List<Double> collect = apple.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println((System.nanoTime() - l)/1_00_000);
    }
}
