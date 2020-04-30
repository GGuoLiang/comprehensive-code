package com.gguoliang.algorithm.leetcode;

import lombok.Data;
import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/4/30 3:19 下午
 * @Version 1.0
 *
 * 俩数相加
 *
 *
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            //取和
            int sumVal = l1Val + l2Val + carry;
            //后移个位
            carry = sumVal / 10;
            //取余
            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return root.next;
    }

    @Test
    public void test(){
        ListNode listNode = new ListNode(1);
        listNode.setNext(new ListNode(2));
        ListNode listNode2 = new ListNode(2);
        listNode2.setNext(new ListNode(3));
        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
        System.out.println(listNode1);

    }
}

@Data
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}