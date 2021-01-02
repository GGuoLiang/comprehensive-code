package com.gguoliang.designPattern.vister.example2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 11:26 上午
 * @Version 1.0
 */
public class BusinessReport {

    private List<Employee> employees;


    public BusinessReport(){
        employees = new ArrayList<>();
        employees.add(new Engineer("工程师A"));
        employees.add(new Engineer("工程师B"));
        employees.add(new Engineer("工程师C"));
        employees.add(new Engineer("工程师D"));
        employees.add(new Manager("经理A"));
        employees.add(new Manager("经理B"));
        employees.add(new Manager("经理C"));
        employees.add(new Manager("经理D"));

    }


    public void showReport(IVisitor iVisitor){
        employees.stream().forEach(employee -> employee.accept(iVisitor));
    }
}
