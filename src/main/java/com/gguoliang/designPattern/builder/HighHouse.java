package com.gguoliang.designPattern.builder;

/**
 * @Author GGuoLiang
 * @Date 2020/10/11 8:18 上午
 * @Version 1.0
 */
public class HighHouse extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("地基20米");
    }

    @Override
    public void buildWalls() {
        System.out.println("围墙20米");
    }

    @Override
    public void roofed() {
        System.out.println("屋顶20米");
    }
}
