package com.gguoliang.designPattern.decorator.drank;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/11/7 10:18 上午
 * @Version 1.0
 */
@Data
public abstract class Drank {

    private Integer price;

    private String dec;

    public int  cost(){
        return price;
    }

    public String description(){
        return dec;
    }
}
