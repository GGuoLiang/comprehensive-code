package com.gguoliang.java8.stream;

import com.gguoliang.java8.methodRefe.Employee;
import com.gguoliang.java8.methodRefe.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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



}
