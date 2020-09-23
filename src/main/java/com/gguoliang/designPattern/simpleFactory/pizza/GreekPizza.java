package com.gguoliang.designPattern.simpleFactory.pizza;

import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 10:28 上午
 * @Version 1.0
 */
public class GreekPizza extends Pizza {

    @Override
    public void prepare(){
        System.out.println("GreekPizza prepare 开始。。。。。");
    }

    @Override
    public void bake(){
        System.out.println("GreekPizza bake 开始。。。。。");
    }

    @Override
    public void cut(){
        System.out.println("GreekPizza cut 开始。。。。。");
    }

    @Override
    public void box(){
        System.out.println(" GreekPizza box 开始。。。。。");
    }
}
