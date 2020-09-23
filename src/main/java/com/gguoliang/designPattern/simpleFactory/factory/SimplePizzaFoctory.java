package com.gguoliang.designPattern.simpleFactory.factory;

import com.gguoliang.designPattern.simpleFactory.pizza.CheesePizza;
import com.gguoliang.designPattern.simpleFactory.pizza.GreekPizza;
import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 10:32 上午
 * @Version 1.0
 */
public class SimplePizzaFoctory {

    public Pizza creatPizza(String type){
        Pizza pizza = null;
        switch (type){
            case "greek":
                pizza=new GreekPizza();
                break;
            case "cheese":
                pizza=new CheesePizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }
}
