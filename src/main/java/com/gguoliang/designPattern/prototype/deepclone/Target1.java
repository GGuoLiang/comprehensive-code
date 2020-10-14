package com.gguoliang.designPattern.prototype.deepclone;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author GGuoLiang
 * @Date 2020/10/10 8:17 上午
 * @Version 1.0
 */
@Data
public class Target1 implements Serializable,Cloneable {

    private String cloneName;

    private String cloneClass;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
