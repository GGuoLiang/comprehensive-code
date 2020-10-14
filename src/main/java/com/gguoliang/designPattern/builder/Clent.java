package com.gguoliang.designPattern.builder;

/**
 * @Author GGuoLiang
 * @Date 2020/10/11 8:20 上午
 * @Version 1.0
 */
public class Clent {

    public static void main(String[] args) {

        // 建造普通房子
        HouseDirector houseDirector = new HouseDirector(new CommHouse());
        houseDirector.constructHouse();

        HouseDirector houseDirector1 = new HouseDirector(new HighHouse());
        houseDirector1.constructHouse();
    }
}
