package com.gguoliang.java8.completablefuture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author GGuoLiang
 * @Date 2020/9/8 10:14 上午
 * @Version 1.0
 */
@Data
public class Apple {


    public Double findPrice(String name){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        return random.nextDouble()+name.charAt(0)+name.charAt(name.length()-1);
    }


    public Double findDiscount(String name){

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        return random.nextDouble();
    }


    public Double findFinalPrice(Double price,Double discount){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return price*discount;
    }


}
