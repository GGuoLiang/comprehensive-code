package com.gguoliang.entity;

import lombok.Data;

/**
 * @Author GGuoLiang
 * @Date 2020/4/21 9:54 上午
 * @Version 1.0
 */
@Data
public class Boy {

    /**
     * 编号
     */
    private int no;
    /**
     * 指向下一个节点,默认 null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
