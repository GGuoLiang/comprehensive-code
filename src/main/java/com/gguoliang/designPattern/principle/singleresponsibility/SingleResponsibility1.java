package com.gguoliang.designPattern.principle.singleresponsibility;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/9/22 10:21 上午
 * @Version 1.0
 * <p>
 * 单一原则
 */
public class SingleResponsibility1 {

    @Test
    public void test1() {
        // 违反的单一原则  负责不通的职责
        Vehicle vehicle = new Vehicle();
        vehicle.run("火车");
        vehicle.run("飞机");
        vehicle.run("轮船");
    }


    @Test
    public void test2() {
        // 方式二 遵循单一原则
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
    }

}
