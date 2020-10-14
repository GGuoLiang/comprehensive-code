package com.gguoliang.designPattern.prototype.deepclone;

/**
 * @Author GGuoLiang
 * @Date 2020/10/10 8:25 上午
 * @Version 1.0
 */
public class Test {

    @org.junit.Test
    public void test() {
        Target2 target2 = new Target2();
        target2.setName("aaaa");
        Target1 target1 = new Target1();
        target1.setCloneName("bbbb");
        target1.setCloneClass("vvvv");
        target2.setTarget1(target1);
        Object clone = target2.clone();
        System.out.println("target2 : " + target2);
        System.out.println("clone :" + clone);
        System.out.println("-----------------------------");
        target1.setCloneName("小册");
        System.out.println("target2 : " + target2);
        System.out.println("clone :" + clone);
    }

    @org.junit.Test
    public void test1(){
        Target2 target2 = new Target2();
        target2.setName("aaaa");
        Target1 target1 = new Target1();
        target1.setCloneName("bbbb");
        target1.setCloneClass("vvvv");
        target2.setTarget1(target1);
        Object clone = target2.deepClone();
        System.out.println("target2 : " + target2);
        System.out.println("clone :" + clone);
        System.out.println("-----------------------------");
        target1.setCloneName("小册");
        System.out.println("target2 : " + target2);
        System.out.println("clone :" + clone);

    }
}
