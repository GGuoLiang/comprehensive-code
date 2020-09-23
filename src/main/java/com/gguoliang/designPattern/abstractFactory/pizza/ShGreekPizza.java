package com.gguoliang.designPattern.abstractFactory.pizza;


/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:33 下午
 * @Version 1.0
 */
public class ShGreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("ShGreekPizza prepare 开始。。。。。");
    }

    @Override
    public void bake() {
        System.out.println("ShGreekPizza bake 开始。。。。。");
    }

    @Override
    public void cut() {
        System.out.println("ShGreekPizza cut 开始。。。。。");
    }

    @Override
    public void box() {
        System.out.println(" ShGreekPizza box 开始。。。。。");
    }
}
