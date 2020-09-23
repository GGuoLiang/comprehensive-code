package com.gguoliang.designPattern.factorymethod.pizza;

/**
 * @Author GGuoLiang
 * @Date 2020/9/23 2:29 下午
 * @Version 1.0
 */
public abstract class Pizza {

    public abstract void prepare();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();
}
