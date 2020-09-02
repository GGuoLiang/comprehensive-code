package com.gguoliang.java8.apple;

import com.gguoliang.java8.apple.Apple;
import com.gguoliang.java8.apple.ApplePredicate;

/**
 * @Author GGuoLiang
 * @Date 2020/9/1 10:15 上午
 * @Version 1.0
 */
public class AppleWeightPredicate implements ApplePredicate {
    @Override
    public Boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
