package com.gguoliang.designPattern.prototype;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/10/10 8:03 上午
 * @Version 1.0
 */
@Data
public class Sheep implements Cloneable {

    private String  name ;

    private Integer age;

    private Sheep friend;

    @Override
    protected Sheep clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }

}
