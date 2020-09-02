package com.gguoliang.java8.completablefuture;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author GGuoLiang
 * @Date 2020/9/1 6:35 上午
 * @Version 1.0
 */
public class Shop {

    private String product;

    public Shop(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice(String product) {
        return this.calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(() -> {
            double calculatePrice = calculatePrice(product);
            completableFuture.complete(calculatePrice);
        }).start();
        return completableFuture;
    }

    public Future<Double> getPriceAsyncPro(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }


    public static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public double calculatePrice(String product) {
        System.out.println(Thread.currentThread().getName());
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);

    }

    public List<Double> findPrice(List<Shop> shops, String product) {
        List<Double> collect = shops.stream().map(shop -> calculatePrice(product)).collect(Collectors.toList());
        return collect;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Shop bestShop = new Shop("BestShop");
        long l = System.currentTimeMillis();
        Future<Double> applePrice = bestShop.getPriceAsync("apple");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(applePrice.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(Thread.currentThread().getName());

    }
}
