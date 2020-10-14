package com.gguoliang.designPattern.builder;

/**
 * @Author GGuoLiang
 * @Date 2020/10/11 8:17 上午
 * @Version 1.0
 */
public class CommHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("地基5米");
    }

    @Override
    public void buildWalls() {
        System.out.println("围墙5米");
    }

    @Override
    public void roofed() {
        System.out.println("屋顶5米");
    }
}
