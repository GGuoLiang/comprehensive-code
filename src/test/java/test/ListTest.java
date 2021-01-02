package test;

import cn.hutool.json.JSONArray;
import com.gguoliang.entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        list.stream().forEach(person -> {
            if(person.getId() == 3){
                return;
            }
            System.out.println(person);
        });
        /*System.out.println(list);
        System.out.println("************************");
        list.stream().forEach(person -> person.setName("12345测试"));
        System.out.println(list);*/



    }


    @Test
    public void test(){
        List<Person> collect = Stream.iterate(0, n -> n + 1).limit(100).map(n -> {
            if (n % 2 == 0) {
                Person person = new Person();
                person.setId(n);
                return person;
            }else {
                return null;
            }
        }).filter(person -> person != null).collect(Collectors.toList());

        System.out.println(collect);
    }
}
