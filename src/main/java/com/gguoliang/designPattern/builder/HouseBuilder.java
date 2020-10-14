package com.gguoliang.designPattern.builder;

/**
 * @Author GGuoLiang
 * @Date 2020/10/11 8:15 上午
 * @Version 1.0
 */
public abstract class HouseBuilder {

    protected House house = new House();

    //将建造的流程写好, 抽象的方法

    public abstract void buildBasic();

    public abstract void buildWalls();

    public abstract void roofed();

    public House getHouse(){
        return house;
    }
}
