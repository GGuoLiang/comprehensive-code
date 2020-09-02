package com.gguoliang.java8.methodRefe;

import java.util.function.Function;

/**
 * @Author GGuoLiang
 * @Date 2020/9/2 8:39 下午
 * @Version 1.0
 */
public class Letter {

    public static String addHeader(String text){
        System.out.println("addHeader:" +System.nanoTime());
        return "header"+text;
    }

    public static String addFooter(String text){
        System.out.println("addFooter:"+System.nanoTime());
        return "Footer"+text;
    }

    public static String check(String text){
        System.out.println("check:"+System.nanoTime());
        return text.replace("aaa","ccc");
    }


    public static void main(String[] args) {
        Function<String,String> function = Letter::addHeader;
        Function<String, String> function1 = function.andThen(Letter::addFooter).andThen(Letter::check);
        System.out.println(function1.apply("aaaabbbbaaa"));

        Function<String, String> function2 = function.compose(Letter::addFooter).compose(Letter::check);
        System.out.println(function2.apply("aaaabbbbaaa"));

    }
}
