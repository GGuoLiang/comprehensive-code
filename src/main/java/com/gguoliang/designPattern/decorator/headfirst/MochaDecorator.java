package com.gguoliang.designPattern.decorator.headfirst;

/**
 * @Author GGuoLiang
 * @Date 2020/12/30 10:52 上午
 * @Version 1.0
 */
public class MochaDecorator extends CoffeeDecorator {

    private Coffee coffee;

    public MochaDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Double cost() {
        return this.coffee.cost()+3.0;
    }

    @Override
    public String getDes() {
        return this.coffee.getDes()+"+一份摩卡";
    }
}
