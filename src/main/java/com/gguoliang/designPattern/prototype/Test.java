package com.gguoliang.designPattern.prototype;

/**
 * @Author GGuoLiang
 * @Date 2020/10/10 8:06 上午
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        Sheep sheep = new Sheep();
        sheep.setName("小黑");
        sheep.setAge(12);
        Sheep sheep1 = new Sheep();
        sheep1.setName("小白");
        sheep1.setAge(15);
        sheep.setFriend(sheep1);
        System.out.println("sheep ："+sheep +" hashcode ："+sheep.hashCode());
        Sheep clone = sheep.clone();
        System.out.println("clone ："+clone+" hashcode ："+clone.hashCode());

        sheep1.setName("小航");
        System.out.println("——————————————————————————————————————————————————————");
        System.out.println("sheep ："+sheep +" hashcode ："+sheep.hashCode());
        System.out.println("clone ："+clone+" hashcode ："+clone.hashCode());


    }
}
