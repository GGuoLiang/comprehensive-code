package com.gguoliang.designPattern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/10/11 8:21 上午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class HouseDirector {

    private HouseBuilder houseBuilder;

    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.roofed();
        return houseBuilder.getHouse();
    }


}
