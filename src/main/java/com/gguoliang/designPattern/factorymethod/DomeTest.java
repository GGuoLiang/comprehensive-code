package com.gguoliang.designPattern.factorymethod;

import com.gguoliang.designPattern.factorymethod.factory.Factory;
import com.gguoliang.designPattern.factorymethod.factory.ProductFactory;
import com.gguoliang.designPattern.factorymethod.product.Product;

/**
 * @Author GGuoLiang
 * @Date 2020/9/11 10:18 上午
 * @Version 1.0
 */
public class DomeTest {

    public static void main(String[] args) {
        Factory factory = new ProductFactory();
        Product cat = factory.create("dog");
        System.out.println(cat.getRound());
    }
}
