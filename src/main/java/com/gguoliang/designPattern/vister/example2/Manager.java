package com.gguoliang.designPattern.vister.example2;

import java.util.Random;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 10:49 上午
 * @Version 1.0
 */
public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }


    public int getProducts(){
        return  new Random().nextInt(1000);
    }

}
