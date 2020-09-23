package com.gguoliang.designPattern.simpleFactory;

import com.gguoliang.designPattern.simpleFactory.factory.SimplePizzaFoctory;
import com.gguoliang.designPattern.simpleFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:26 下午
 * @Version 1.0
 */
public class OrderPizza {

    public static void main(String[] args) {
        SimplePizzaFoctory simplePizzaFoctory = new SimplePizzaFoctory();
        Pizza pizza = simplePizzaFoctory.creatPizza("cheese");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
