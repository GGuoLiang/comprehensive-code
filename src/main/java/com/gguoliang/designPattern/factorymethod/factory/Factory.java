package com.gguoliang.designPattern.factorymethod.factory;

import com.gguoliang.designPattern.factorymethod.product.Product;

/**
 * @Author GGuoLiang
 * @Date 2020/9/11 10:10 上午
 * @Version 1.0
 */
public interface Factory {

    Product create(String productType);

}
