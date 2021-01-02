package com.gguoliang.designPattern.proxy.dynamic;

/**
 * @Author GGuoLiang
 * @Date 2020/11/12 9:27 上午
 * @Version 1.0
 */
public class Client {

    public static void main(String[] args) {

        ITeacherDao iTeacherDao = new TeacherDaoImpl();
        ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(iTeacherDao).getProxyInstance();
        System.out.println("proxyInstance:" + proxyInstance.getClass());
        proxyInstance.teach();

    }
}
