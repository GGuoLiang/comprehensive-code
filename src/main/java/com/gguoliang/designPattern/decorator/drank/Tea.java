package com.gguoliang.designPattern.decorator.drank;

/**
 * @Author GGuoLiang
 * @Date 2020/11/7 11:07 上午
 * @Version 1.0
 */
public class Tea extends Drank {

    public Tea(){
        super();
        setDec(" 茶 ");
        setPrice(100);
    }
}
