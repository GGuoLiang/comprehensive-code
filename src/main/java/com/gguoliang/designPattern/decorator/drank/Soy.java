package com.gguoliang.designPattern.decorator.drank;

import com.gguoliang.designPattern.decorator.drank.Drank;
import com.gguoliang.designPattern.decorator.drank.DrankDecorator;

/**
 * @Author GGuoLiang
 * @Date 2020/11/7 10:38 上午
 * @Version 1.0
 */
public class Soy extends DrankDecorator {

    public Soy(Drank drank) {
        super(drank);
        setDec("豆浆");
        setPrice(30);
    }
}
