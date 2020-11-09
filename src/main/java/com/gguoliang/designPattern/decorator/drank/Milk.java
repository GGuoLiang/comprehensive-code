package com.gguoliang.designPattern.decorator.drank;

import com.gguoliang.designPattern.decorator.drank.Drank;
import com.gguoliang.designPattern.decorator.drank.DrankDecorator;

/**
 * @Author GGuoLiang
 * @Date 2020/11/7 10:31 上午
 * @Version 1.0
 */
public class Milk extends DrankDecorator {

    public Milk(Drank drank) {
        super(drank);
        setDec("牛奶");
        setPrice(20);
    }


}
