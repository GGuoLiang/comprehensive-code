package com.gguoliang.designPattern.vister.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 9:21 上午
 * @Version 1.0
 */
public class Woman implements Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult();
    }
}
