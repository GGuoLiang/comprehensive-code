package com.gguoliang.designPattern.vister.example2;

/**
 * @Author GGuoLiang
 * @Date 2020/11/23 11:32 上午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {

        BusinessReport businessReport = new BusinessReport();
        businessReport.showReport(new CEOVisitor());

    }
}
