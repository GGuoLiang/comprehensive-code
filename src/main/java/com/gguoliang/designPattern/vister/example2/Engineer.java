package com.gguoliang.designPattern.vister.example2;

import java.util.Random;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 10:44 上午
 * @Version 1.0
 */
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

    public int getCodeLine(){
        return new Random().nextInt(100_000);
    }
}
