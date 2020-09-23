package com.gguoliang.designPattern.abstractFactory.factory;


import com.gguoliang.designPattern.abstractFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:45 下午
 * @Version 1.0
 */
public abstract class AbstractFoactory {

    public abstract Pizza creatPizza(String name);
}
