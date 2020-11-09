package com.gguoliang.designPattern.decorator.drank;

/**
 * @Author GGuoLiang
 * @Date 2020/11/7 10:42 上午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        Drank drank = new Coffee();
        System.out.println("cost:" + drank.cost() + "\n" + "dec:" + drank.description());
        // 加牛奶
        drank = new Milk(drank);
        System.out.println("cost:" + drank.cost() + "\n" + "dec:" + drank.description());

        // 再加牛奶
        drank = new Milk(drank);
        System.out.println("cost:" + drank.cost() + "\n" + "dec:" + drank.description());

        // 加豆浆
        drank = new Soy(drank);
        System.out.println("cost:" + drank.cost() + "\n" + "dec:" + drank.description());

        Drank drank1 = new Tea();
        System.out.println("cost:" + drank1.cost() + "\n" + "dec:" + drank1.description());
        // 加牛奶
        drank1 = new Milk(drank1);
        System.out.println("cost:" + drank1.cost() + "\n" + "dec:" + drank1.description());

        System.out.println("-------------------------");

        Drank drank2 = new LongBlack();
        System.out.println("cost:" + drank2.cost() + "\n" + "dec:" + drank2.description());
        // 加牛奶
        drank2 = new Milk(drank2);
        System.out.println("cost:" + drank2.cost() + "\n" + "dec:" + drank2.description());


    }
}
