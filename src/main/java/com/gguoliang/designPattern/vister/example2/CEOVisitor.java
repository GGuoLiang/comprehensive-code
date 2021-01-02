package com.gguoliang.designPattern.vister.example2;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 10:51 上午
 * @Version 1.0
 */
public class CEOVisitor implements IVisitor {

    @Override
    public void visit(Employee employee) {
        if(employee instanceof Engineer){
            Engineer engineer = (Engineer) employee;
            System.out.println("工程师"+employee.getName()+" 一年的代码量 "+engineer.getCodeLine());
        }else if (employee instanceof Manager){
            Manager manager = (Manager) employee;
            System.out.println("经理"+employee.getName()+" 一年产品数 "+manager.getProducts());
        }
    }
}
