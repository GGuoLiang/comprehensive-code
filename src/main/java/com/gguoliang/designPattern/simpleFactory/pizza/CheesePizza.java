package com.gguoliang.designPattern.simpleFactory.pizza;

import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 10:30 上午
 * @Version 1.0
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare(){
        System.out.println("CheesePizza prepare 开始。。。。。");
    }

    @Override
    public void bake(){
        System.out.println("CheesePizza bake 开始。。。。。");
    }

    @Override
    public void cut(){
        System.out.println("CheesePizza cut 开始。。。。。");
    }

    @Override
    public void box(){
        System.out.println(" CheesePizza box 开始。。。。。");
    }
}
