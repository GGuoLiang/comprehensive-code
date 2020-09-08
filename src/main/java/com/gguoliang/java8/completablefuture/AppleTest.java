package com.gguoliang.java8.completablefuture;



import cn.hutool.json.JSONUtil;
import com.google.common.collect.Maps;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author GGuoLiang
 * @Date 2020/9/8 10:18 上午
 * @Version 1.0
 */
public class AppleTest {


    @Test
    public void test(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Apple apple = new Apple();
        Future<Double> iphone7 = executorService.submit(() -> apple.findPrice("iphone7"));
        try {
            System.out.println(iphone7.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Apple apple = new Apple();
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        executorService.submit(()->{
            Double ipone7_pro = apple.findPrice("ipone7 pro");
            try {
                completableFuture.complete(ipone7_pro);
            }catch (Exception ex){
                completableFuture.completeExceptionally(ex);
            }

        });
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        Apple apple = new Apple();
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> apple.findPrice("iphone8"),Executors.newFixedThreadPool(10));
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test4(){
        List<String> list = Arrays.asList("ipone4", "ipone5", "ipone5s", "ipone6", "ipone6s", "ipone7", "ipone7s", "ipone8", "iponex","ipone4", "ipone5", "ipone5s", "ipone6", "ipone6s", "ipone7", "ipone7s", "ipone8", "iponex");
        Apple apple = new Apple();
        /*long l1 = System.currentTimeMillis();
        List<Double> collect = list.stream().map(string -> apple.findPrice(string)).collect(Collectors.toList());
        System.out.println("Stream："+(System.currentTimeMillis() - l1));*/
        long l2 = System.currentTimeMillis();
        List<Double> collect1 = list.parallelStream().map(string -> apple.findPrice(string)).collect(Collectors.toList());
        System.out.println("ParallelStream："+(System.currentTimeMillis() - l2));

        long l3 = System.currentTimeMillis();
        List<CompletableFuture<Double>> collect2 = list.stream().map(str -> CompletableFuture.supplyAsync(() -> apple.findPrice(str),Executors.newFixedThreadPool(20))).collect(Collectors.toList());
        //这里使用了两个不同的Stream流水线:如果在单一流水线中处理流，那么发向不同商家的请求只能以同步、顺序执行的方式才会成功
        List<Double> collect3 = collect2.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("CompletableFuture："+(System.currentTimeMillis() - l3));

    }

    @Test
    public void test5(){
        List<String> list = Arrays.asList("ipone4", "ipone5", "ipone5s", "ipone6", "ipone6s", "ipone7", "ipone7s", "ipone8", "iponex","ipone4", "ipone5", "ipone5s", "ipone6", "ipone6s", "ipone7", "ipone7s", "ipone8", "iponex");
        Apple apple = new Apple();
        List<CompletableFuture<Double>> collect
                = list.stream().map(string -> CompletableFuture.supplyAsync(() -> apple.findPrice(string))
                .thenCombine(CompletableFuture.supplyAsync(() -> apple.findDiscount(string)),
                        (price, discount) -> apple.findFinalPrice(price, discount))).collect(Collectors.toList());
        List<Double> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(collect1);
    }


    @Test
    public void thenApply(){
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> "GGuo").thenApply(string -> string + " Liang");
        System.out.println(stringCompletableFuture.join());

    }

    @Test
    public void thenAccept(){
        CompletableFuture.supplyAsync(()->"Hello").thenAccept(System.out::println);
    }

    @Test
    public void thenRun(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("当前线程："+Thread.currentThread().getName()+" 执行时间 "+System.currentTimeMillis());
            return "Hello";
        }).thenRun(()-> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+Thread.currentThread().getName()+System.currentTimeMillis());
            System.out.println("world");
        });
    }


    @Test
    public void thenCompose(){
        String join = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程："+Thread.currentThread().getName()+" 执行时间 "+System.currentTimeMillis());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "GGuo";
        }).thenCompose(string -> CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+Thread.currentThread().getName()+" 执行时间 "+System.currentTimeMillis());
            return string + "Liang";
        })).join();
        System.out.println(join);
    }

    @Test
    public void thenCombine(){
        String join = CompletableFuture.supplyAsync(() -> "GGuoLiang")
                .thenCombine(CompletableFuture.supplyAsync(() -> "Liang"),
                        (a, b) -> a + b).join();
        System.out.println(join);
    }


    @Test
    public void thenAcceptBoth(){
        CompletableFuture.supplyAsync(()->"GGuoLiang")
                .thenAcceptBoth(CompletableFuture.supplyAsync(()->"thenAcceptBoth"),
                        (a,b)-> System.out.println(a+" 测试 "+b));
    }

    @Test
    public void runAfterBoth(){
        CompletableFuture.supplyAsync(()->"GGuoLiang")
                .runAfterBoth(CompletableFuture.supplyAsync(()->"runAfterBoth"),
                        ()-> System.out.println("执行完毕"));
    }

    @Test
    public void applyToEither(){
        String join = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "GGuoLiang";
        }).applyToEither(CompletableFuture.supplyAsync(() -> "runAfterBoth"), a -> a).join();
        System.out.println(join);
    }

    @Test
    public void acceptEither(){
       CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "GGuoLiang";
        }).acceptEither(CompletableFuture.supplyAsync(() -> "runAfterBoth"), System.out::println);
    }


    @Test
    public void runAfterEither(){
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "GGuoLiang";
        }).runAfterEither(CompletableFuture.supplyAsync(() -> "runAfterBoth"),
                ()-> System.out.println("执行完毕"));
    }

    @Test
    public void exceptionally(){
        Object str = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("exceptionally 异常测试");
        }).exceptionally(Throwable::getMessage).join();
        System.out.println(str.toString());
    }

    @Test
    public void whenComplete(){
        String  whenComplete = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException("whenComplete 异常测试");
            }
            return "GGuoLiang";
        }).whenComplete((s, t) -> {
           if(s == null){
               System.out.println(t.getMessage());
           }else{
               System.out.println(s);
           }
        }).join();
        System.out.println(whenComplete);

    }

    @Test
    public void handle(){
        String  handle = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (true) {
                throw new RuntimeException("whenComplete 异常测试");
            }
            return "GGuoLiang";
        }).handle((s, t) -> {
            if(s == null){
               return t.getMessage();
            }else{
               return s;
            }
        }).join();
        System.out.println(handle);

    }


}
