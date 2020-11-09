package com.gguoliang.designPattern.composite;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/11/8 4:13 下午
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public abstract class Component {

    private String name;
    private String desc;



    public void add(Component component) {

    }

    public void remove(Component component) {

    }

    public void foreach(){


    }

}
