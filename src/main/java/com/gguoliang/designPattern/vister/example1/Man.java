package com.gguoliang.designPattern.vister.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 9:20 上午
 * @Version 1.0
 */
public class Man implements  Person {
    @Override
    public void accept(Action action) {
        action.getManResult();
    }
}
