package test;

import cn.hutool.json.JSONArray;
import com.gguoliang.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/7/10 11:06 上午
 * @Version 1.0
 */
public class ListTest {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("ceshi"+i);
            list.add(person);
        }
        System.out.println(list);
        System.out.println("************************");
        list.stream().filter(person -> person.getId() != 2).forEach(person -> person.setName("12345测试"));
        System.out.println(list);


    }
}
