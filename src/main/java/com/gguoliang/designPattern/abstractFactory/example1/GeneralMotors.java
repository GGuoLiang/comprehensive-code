package com.gguoliang.designPattern.abstractFactory.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/9/15 7:18 上午
 * @Version 1.0
 */
public class GeneralMotors extends Car {
    @Override
    public Parts getWheels() {
        return new Parts("GeneralMotors wheels");
    }

    @Override
    public Parts getMirrors() {
        return new Parts("GeneralMotors mirrors");
    }

    @Override
    public Parts getEngine() {
        return new Parts("GeneralMotors engine");
    }

    @Override
    public Parts getBody() {
        return new Parts("GeneralMotors body");
    }
}
