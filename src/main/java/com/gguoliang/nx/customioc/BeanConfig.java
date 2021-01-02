package com.gguoliang.nx.customioc;

import java.util.HashMap;
import java.util.List;

/**
 * @author 奈学-肖秋平老师 Eric
 **/
public class BeanConfig {  //spring-ioc.xml spring-di.xml

    private String id;
    private String clazz;
    private String factoryMethod;
    private String factoryBean;

    private HashMap DependencyHashMap = new HashMap<String, List<String>>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }


}
