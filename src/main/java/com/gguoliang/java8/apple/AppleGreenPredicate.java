package com.gguoliang.java8.apple;

/**
 * @Author GGuoLiang
 * @Date 2020/9/1 10:14 上午
 * @Version 1.0
 */
public class AppleGreenPredicate implements ApplePredicate {
    @Override
    public Boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
