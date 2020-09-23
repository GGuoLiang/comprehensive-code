package com.gguoliang.designPattern.factorymethod.pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:33 下午
 * @Version 1.0
 */
public class ShCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("ShCheesePizza prepare 开始。。。。。");
    }

    @Override
    public void bake() {
        System.out.println("ShCheesePizza bake 开始。。。。。");
    }

    @Override
    public void cut() {
        System.out.println("ShCheesePizza cut 开始。。。。。");
    }

    @Override
    public void box() {
        System.out.println(" ShCheesePizza box 开始。。。。。");
    }
}
