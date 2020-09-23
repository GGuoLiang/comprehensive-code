package com.gguoliang.designPattern.factorymethod.order;

import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:31 下午
 * @Version 1.0
 */
public abstract class OrderPizza {

    public abstract Pizza createPizza(String type);
}
