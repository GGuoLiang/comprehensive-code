package com.gguoliang.nx.customioc;

import java.util.List;

/**
 * @Author GGuoLiang
 * @Date 2020/12/16 10:42 下午
 * @Version 1.0
 */
public class BootStrap {
    public static void main(String[] args) throws ClassNotFoundException {

        List<BeanConfig> beanConfigList = getBeanConfigList();
        for (BeanConfig beanConfig : beanConfigList) {
           if(beanConfig.getClazz() != null){
               Class<?> aClass = Class.forName(beanConfig.getClazz());
               if(beanConfig.getFactoryBean() != null){


               }

           }


        }


    }




    public static List<BeanConfig>  getBeanConfigList(){
        return null;
    }

}
