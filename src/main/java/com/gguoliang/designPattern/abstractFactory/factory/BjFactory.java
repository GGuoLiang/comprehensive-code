package com.gguoliang.designPattern.abstractFactory.factory;

import com.gguoliang.designPattern.abstractFactory.pizza.BjCheesePizza;
import com.gguoliang.designPattern.abstractFactory.pizza.Pizza;
import com.gguoliang.designPattern.simpleFactory.pizza.CheesePizza;


/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:46 下午
 * @Version 1.0
 */
public class BjFactory extends AbstractFoactory {

    @Override
    public Pizza creatPizza(String name) {
        Pizza pizza =null;
        switch (name){
            case "greek":
                pizza = new BjCheesePizza();
                break;
            case "cheese":
                pizza = new BjCheesePizza();
            default:
                pizza = null;
        }
        return pizza;
    }
}
