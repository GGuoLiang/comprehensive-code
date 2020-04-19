package com.gguoliang.dataStructures.list;

import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/3/22 5:36 下午
 * @Version 1.0
 */
public class SingleLinkedListTest {

    @Test
    public void test() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        for (int i = 1; i <= 20; i++) {
            singleLinkedList.add(new Node(i,i+"节点"));
        }
        singleLinkedList.show();
        System.out.println("倒数节点"+singleLinkedList.getNodeByListIndex(1).toString());
        System.out.println("*********************************");
        System.out.println("链表的长度"+singleLinkedList.size());
       /* singleLinkedList.serverLinkedList();
        singleLinkedList.show();*/
        System.out.println("*********************************");
        singleLinkedList.serverLinkedPrint();
       /* singleLinkedList.delete(21);
        singleLinkedList.show();
        System.out.println("*********************************");
        singleLinkedList.update(19,"修改名称");
        singleLinkedList.show();
        System.out.println("*********************************");
        singleLinkedList.addByNo(new Node(12,"附加节点"));
        singleLinkedList.show();
*/

    }

}
