package com.gguoliang.nx.classLoader;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author GGuoLiang
 * @Date 2020/12/16 9:53 下午
 * @Version 1.0
 */
public class ClassLoaderFrame {

    public ClassLoaderFrame(){

    }



    public  void runClass(String name) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new GLClassLoader();
        Class<?> aClass = classLoader.loadClass(name);
        Method main = aClass.getMethod("main",String[].class);
        main.invoke(null, (Object) new String[] {});
        Object o = aClass.newInstance();
        Method setName = aClass.getMethod("setName", String.class);
        setName.invoke(o,"123");
        System.out.println(o);

    }

}
