package com.gguoliang.designPattern.factorymethod.order;

import com.gguoliang.designPattern.factorymethod.pizza.BjCheesePizza;
import com.gguoliang.designPattern.factorymethod.pizza.BjGreekPizza;
import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:38 下午
 * @Version 1.0
 */
public class ShOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "greek":
                pizza = new BjGreekPizza();
                break;
            case "cheese":
                pizza = new BjCheesePizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }

    public static void main(String[] args) {
        ShOrderPizza shOrderPizza = new ShOrderPizza();
        Pizza greek = shOrderPizza.createPizza("greek");
        greek.prepare();
        greek.bake();
        greek.cut();
        greek.box();
    }
}
