package com.gguoliang.designPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author GGuoLiang
 * @Date 2020/11/12 9:20 上午
 * @Version 1.0
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target=target;
    }



    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK动态代理开始");
                Object invoke = method.invoke(target, args);
                System.out.println("JDK动态代理已提交");
                return invoke;
            }
        });
    }
}
