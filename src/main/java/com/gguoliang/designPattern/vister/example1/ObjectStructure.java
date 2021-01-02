package com.gguoliang.designPattern.vister.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 9:21 上午
 * @Version 1.0
 */
public class ObjectStructure {

    private List<Person> personList;

    public ObjectStructure(){
        personList = new ArrayList<>();
    }

    public ObjectStructure(List<Person> personList){
        this.personList = personList;
    }

    public void  addPerson(Person person){

        personList.add(person);
    }

    public void disPlay(Action action){
        personList.stream().forEach(person -> person.accept(action));
    }
}
