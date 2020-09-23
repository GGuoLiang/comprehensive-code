package com.gguoliang.designPattern.abstractFactory;

import com.gguoliang.designPattern.abstractFactory.factory.BjFactory;
import com.gguoliang.designPattern.abstractFactory.factory.ShFactory;
import com.gguoliang.designPattern.abstractFactory.pizza.Pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:52 下午
 * @Version 1.0
 */
public class OrderPizza {

    public static void main(String[] args) {
        BjFactory bjFactory = new BjFactory();
        Pizza greek = bjFactory.creatPizza("greek");
        greek.prepare();
        greek.bake();
        greek.cut();
        greek.box();

        ShFactory shFactory = new ShFactory();
        Pizza cheese = shFactory.creatPizza("cheese");
        cheese.prepare();
        cheese.bake();
        cheese.cut();
        cheese.box();



    }
}
