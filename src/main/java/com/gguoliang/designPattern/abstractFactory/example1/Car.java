package com.gguoliang.designPattern.abstractFactory.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/9/15 7:10 上午
 * @Version 1.0
 */
public abstract class Car {

    public abstract Parts getWheels();
    public abstract Parts getMirrors();
    public abstract Parts getEngine();
    public abstract Parts getBody();


}
