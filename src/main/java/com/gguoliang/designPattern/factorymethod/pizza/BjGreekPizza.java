package com.gguoliang.designPattern.factorymethod.pizza;

import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 10:28 上午
 * @Version 1.0
 */
public class BjGreekPizza extends Pizza {

    @Override
    public void prepare(){
        System.out.println("BjGreekPizza prepare 开始。。。。。");
    }

    @Override
    public void bake(){
        System.out.println("BjGreekPizza bake 开始。。。。。");
    }

    @Override
    public void cut(){
        System.out.println("BjGreekPizza cut 开始。。。。。");
    }

    @Override
    public void box(){
        System.out.println(" BjGreekPizza box 开始。。。。。");
    }
}
