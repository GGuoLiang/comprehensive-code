package com.gguoliang.designPattern.abstractFactory.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/9/15 7:14 上午
 * @Version 1.0
 */
public class BenQ extends Car {


    @Override
    public Parts getWheels() {
        return new Parts("BenQ wheels");
    }

    @Override
    public Parts getMirrors() {
        return new Parts("BenQ mirrors");
    }

    @Override
    public Parts getEngine() {
        return new Parts("BenQ engine");
    }

    @Override
    public Parts getBody() {
        return new Parts("BenQ body");
    }
}
