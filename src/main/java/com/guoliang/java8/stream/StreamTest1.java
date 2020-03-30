package com.guoliang.java8.stream;

import com.guoliang.java8.java2.Employee;
import com.guoliang.java8.java2.EmployeeData;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author GGuoLiang
 * @Date 2020/3/27 4:19 下午
 * @Version 1.0
 */
public class StreamTest1 {

    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();
//        filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //筛选 工资大于7000
        stream.filter(employee -> employee.getSalary()>7000).forEach( employee -> System.out.println(employee));
        System.out.println(list);
        //元素不能超过设置额数量
        list.stream().limit(3).forEach(employee -> System.out.println(employee));
        System.out.println();
        //跳过元素的前三位数量
        list.stream().skip(3).forEach(employee -> System.out.println(employee));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",41,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));

        list.stream().distinct().forEach(employee -> System.out.println(employee));
        System.out.println();
        list.stream().sorted(( o1, o2) -> Double.compare(o1.getSalary(),o2.getSalary())).forEach(employee -> System.out.println(employee));

    }
}
