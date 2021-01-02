package com.gguoliang.designPattern.decorator.headfirst;

/**
 * @Author GGuoLiang
 * @Date 2020/12/30 10:36 上午
 * @Version 1.0
 */
public class MailDecorator extends CoffeeDecorator {

   private Coffee coffee;

    public MailDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDes() {
        return this.coffee.getDes()+"+一份牛奶";
    }

    @Override
    public Double cost() {
        return this.coffee.cost()+2.0;
    }
}
