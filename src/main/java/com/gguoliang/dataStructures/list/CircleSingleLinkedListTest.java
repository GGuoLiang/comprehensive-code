package com.gguoliang.dataStructures.list;

import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/4/21 9:14 上午
 * @Version 1.0
 */
public class CircleSingleLinkedListTest {

    @Test
    public void test1(){
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.show();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
