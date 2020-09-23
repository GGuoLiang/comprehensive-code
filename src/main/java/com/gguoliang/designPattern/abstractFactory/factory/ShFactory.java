package com.gguoliang.designPattern.abstractFactory.factory;

import com.gguoliang.designPattern.abstractFactory.pizza.BjCheesePizza;
import com.gguoliang.designPattern.abstractFactory.pizza.Pizza;
import com.gguoliang.designPattern.abstractFactory.pizza.ShCheesePizza;
import com.gguoliang.designPattern.simpleFactory.pizza.CheesePizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:46 下午
 * @Version 1.0
 */
public class ShFactory extends AbstractFoactory {
    @Override
    public com.gguoliang.designPattern.abstractFactory.pizza.Pizza creatPizza(String name) {
        Pizza pizza =null;
        switch (name){
            case "greek":
                pizza = new ShCheesePizza();
                break;
            case "cheese":
                pizza = new ShCheesePizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }
}
