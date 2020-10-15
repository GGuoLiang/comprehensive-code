package com.gguoliang.designPattern.bridge;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/10/14 4:34 下午
 * @Version 1.0
 */
@Data
public class Phone {

    private Brand brand;

    public void call(String name) {
        brand.call(name);

    }
}
