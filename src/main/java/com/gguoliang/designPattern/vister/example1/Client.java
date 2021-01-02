package com.gguoliang.designPattern.vister.example1;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 9:57 上午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {
        ObjectStructure objectStructure =new ObjectStructure();
        objectStructure.addPerson(new Man());
        objectStructure.addPerson(new Woman());
        Success success = new Success();
        objectStructure.disPlay(success);
        Fail fail = new Fail();
        Wait wait =  new Wait();
        objectStructure.disPlay(fail);
        objectStructure.disPlay(wait);
    }
}
