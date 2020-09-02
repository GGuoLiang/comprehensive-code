package com.gguoliang.java8.methodRefe;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author GGuoLiang
 * @Date 2020/9/2 8:05 下午
 * @Version 1.0
 */
public class MethodRefTest1 {

    @Test
    public void test(){

        Function<Employee,String> function = (Employee employee) -> employee.getName();

        Employee employee = new Employee();
        // 对象：：方法
        Function<String,Integer> function1 = employee::getId;

        // 类 ：： 方法
        Function<Employee,Integer> function2 = Employee::getId;

        //类 ：： 静态方法
    }


    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();
        // 以员工的工资排序
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);
        employees.sort(comparator);
        employees.stream().forEach(System.out::println);
        // 逆序排序
        employees.sort(comparator.reversed());
        employees.stream().forEach(System.out::println);
        // 出现工资一样的以名称排序
        employees.sort(comparator.reversed().thenComparing(Employee::getName));
        employees.stream().forEach(System.out::println);

    }

    @Test
    public void test3(){
        Predicate<Employee> predicate = employee -> employee.getSalary() > 30000;

        // &&
        Predicate<Employee> and = predicate.and(employee -> employee.getId() == 2222);

        // ||
        Predicate<Employee> or = predicate.or(employee -> employee.getSalary() < 100);

        // 非
        Predicate<Employee> negate = predicate.negate();
    }


}
