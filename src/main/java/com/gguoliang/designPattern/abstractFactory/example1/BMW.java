package com.gguoliang.designPattern.abstractFactory.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/9/15 7:17 上午
 * @Version 1.0
 */
public class BMW extends Car {

    @Override
    public Parts getWheels() {
        return new Parts("BWM wheels");
    }

    @Override
    public Parts getMirrors() {
        return new Parts("BWM mirrors");
    }

    @Override
    public Parts getEngine() {
        return new Parts("BWM engine");
    }

    @Override
    public Parts getBody() {
        return new Parts("BWM body");
    }
}
