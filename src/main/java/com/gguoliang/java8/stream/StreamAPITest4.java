package com.gguoliang.java8.stream;

import com.gguoliang.java8.methodRefe.Employee;
import com.gguoliang.java8.methodRefe.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author GGuoLiang
 * @Date 2020/8/22 7:52 下午
 * @Version 1.0
 *
 *  collect 操作
 */
public class StreamAPITest4 {

    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        Map<Integer, List<Employee>> collect = employees.stream().map(employee -> {
            employee.setId(999 + employee.getId());
            return employee;
        }).collect(Collectors.groupingBy(Employee::getId));

        Map<Integer, List<Map<String, Object>>> collect1
                = employees.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.mapping(Employee::toMMap, Collectors.toList())));
        System.out.println(collect1);
    }


    @Test
    public void test() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        OptionalInt max = integerStream.mapToInt(Integer::intValue).max();
        System.out.println(max.orElse(1));
    }


    @Test
    public void test3(){
        List<Employee> employees = EmployeeData.getEmployees();
        // 集合个数
        Long collect = employees.stream().collect(Collectors.counting());
        System.out.println(collect);
        System.out.println(employees.stream().count());

        //最大最小值
        Optional<Employee> collect1 = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(collect1.get());
        Optional<Employee> collect2 = employees.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(collect2.get());

        // 汇总
        Integer collect3 = employees.stream().collect(Collectors.summingInt(Employee::getId));
        System.out.println(collect3);
    }

    @Test
    public void test4(){
        List<Employee> employees = EmployeeData.getEmployees();
        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println(collect);
        // 添加分隔符
        String collect1 = employees.stream().map(Employee::getName).collect(Collectors.joining("，"));
        System.out.println(collect1);
        // 添加分隔符，开头 结尾
        String collect2 = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "开头", "结尾"));
        System.out.println(collect2);
    }


    @Test
    public  void test5(){
        List<Employee> employees = EmployeeData.getEmployees();
        // 按工资分组
        Map<Double, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(collect);

        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(employee -> {
            if (employee.getSalary() > 9000) {
                return "gao";
            } else if (employee.getSalary() > 500) {
                return "zhong";
            } else {
                return "di";
            }
        }));
        System.out.println(collect1);

        Map<Double, List<String>> collect2 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(collect2);

        HashMap<Double, List<Integer>> collect3 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, HashMap::new, Collectors.mapping(Employee::getAge, Collectors.toList())));

        // 多级分组
        Map<Double, Map<Integer, List<Employee>>> collect4 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy(Employee::getAge)));

        Map<Double, Optional<Employee>> collect5 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.maxBy(Comparator.comparing(Employee::getName))));

        Map<Double, Employee> collect6 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getId)), Optional::get)));


        Map<Double, Set<String>> collect7 = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toSet())));


    }


    @Test
    public  void test6(){
        // 分区
        List<Employee> employees = EmployeeData.getEmployees();
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getSalary() > 1000));
    }
}
