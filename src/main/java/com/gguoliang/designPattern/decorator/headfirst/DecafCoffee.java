package com.gguoliang.designPattern.decorator.headfirst;

/**
 * @Author GGuoLiang
 * @Date 2020/12/30 10:33 上午
 * @Version 1.0
 */
public class DecafCoffee extends Coffee {

    @Override
    public Double cost() {
        return 20.0;
    }

    @Override
    public String getDes() {
        return "DecafCoffee";
    }
}
