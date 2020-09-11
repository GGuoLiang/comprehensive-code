package com.gguoliang.designPattern.factorymethod.factory;

import com.gguoliang.designPattern.factorymethod.product.CatProduct;
import com.gguoliang.designPattern.factorymethod.product.DogProduct;
import com.gguoliang.designPattern.factorymethod.product.Product;

/**
 * @Author GGuoLiang
 * @Date 2020/9/11 10:14 上午
 * @Version 1.0
 */
public class ProductFactory implements Factory {

    @Override
    public Product create(String productType) {
        if ("dog".equals(productType)) {
            return new DogProduct();
        } else {
            return new CatProduct();
        }
    }
}
