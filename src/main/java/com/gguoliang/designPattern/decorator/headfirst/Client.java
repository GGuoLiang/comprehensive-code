package com.gguoliang.designPattern.decorator.headfirst;

/**
 * @Author GGuoLiang
 * @Date 2020/12/30 10:43 上午
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        DecafCoffee decafCoffee = new DecafCoffee();
        System.out.println("当前饮料描述："+ decafCoffee.getDes() + " 花费："+decafCoffee.cost());
        MailDecorator mailDecorator = new MailDecorator(decafCoffee);
        System.out.println("当前饮料描述："+ mailDecorator.getDes() + " 花费："+mailDecorator.cost());
        MailDecorator mailDecorator1 = new MailDecorator(mailDecorator);
        System.out.println("当前饮料描述："+ mailDecorator1.getDes() + " 花费："+mailDecorator1.cost());
        MochaDecorator mochaDecorator = new MochaDecorator(mailDecorator1);
        System.out.println("当前饮料描述："+ mochaDecorator.getDes() + " 花费："+mochaDecorator.cost());
    }
}
