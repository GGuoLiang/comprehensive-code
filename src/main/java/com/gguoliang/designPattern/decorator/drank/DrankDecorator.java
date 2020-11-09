package com.gguoliang.designPattern.decorator.drank;

import com.gguoliang.designPattern.decorator.drank.Drank;
import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/11/7 10:20 上午
 * @Version 1.0
 */
@Data
public class DrankDecorator extends Drank {

    private Drank drank;


    public DrankDecorator(Drank drank){
        this.drank= drank;

    }

    @Override
    public int cost() {
        return super.cost() +drank.cost();
    }

    @Override
    public String description() {
        return super.description()+"&&"+drank.description();
    }
}
