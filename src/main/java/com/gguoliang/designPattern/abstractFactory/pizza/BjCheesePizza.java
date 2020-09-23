package com.gguoliang.designPattern.abstractFactory.pizza;


/**
 * @Author GGuoLiang
 * @Date 2020/9/23 10:30 上午
 * @Version 1.0
 */
public class BjCheesePizza extends Pizza {
    @Override
    public void prepare(){
        System.out.println("BjCheesePizza prepare 开始。。。。。");
    }

    @Override
    public void bake(){
        System.out.println("BjCheesePizza bake 开始。。。。。");
    }

    @Override
    public void cut(){
        System.out.println("BjCheesePizza cut 开始。。。。。");
    }

    @Override
    public void box(){
        System.out.println(" BjCheesePizza box 开始。。。。。");
    }
}
