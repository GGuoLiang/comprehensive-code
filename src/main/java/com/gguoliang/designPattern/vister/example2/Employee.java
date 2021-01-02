package com.gguoliang.designPattern.vister.example2;

import java.util.Random;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 10:41 上午
 * @Version 1.0
 */
public abstract class Employee {

    private  String  name ;

    private int kpi;

    public Employee(String name){
        this.name = name;
        kpi = new Random().nextInt(10);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKpi() {
        return kpi;
    }

    public void setKpi(int kpi) {
        this.kpi = kpi;
    }

    public abstract void accept(IVisitor iVisitor);


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", kpi=" + kpi +
                '}';
    }
}
