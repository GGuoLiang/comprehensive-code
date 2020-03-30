package com.guoliang.java8;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;
import java.util.function.Supplier;


/**
 * @Author GGuoLiang
 * @Date 2020/3/29 11:11 下午
 * @Version 1.0
 *
 * 方法引用
 */
public class Java5 {



    @Test
    public  void test1(){
        Consumer<String> constructor = s -> System.out.println(s);
        constructor.accept("北京");

        Consumer<String> consumer1 = System.out :: println;
        consumer1.accept("北京");
    }

    @Test
    public void test2(){
        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "test";
            }
        };

        Supplier<String> stringSupplier1 = String::new;
    }
}
