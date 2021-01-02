package com.gguoliang.designPattern.decorator.headfirst;

/**
 * @Author GGuoLiang
 * @Date 2020/12/30 10:28 上午
 * @Version 1.0
 */
public abstract class Coffee {

    private String des;


    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public abstract Double cost();
}
