package com.guoliang.datasource;

import org.junit.Test;

import java.util.HashMap;

/**
 * 单链表结构
 *
 * @author guoliang
 */
public class SingleLinkedList {

    /**
     * 该链表的头结点
     */
    private Node headNode;

    public SingleLinkedList(){
        headNode = new Node(0,"头结点");
    }

    public void add(Node node) {
        //遍历整个的链表 找到链表的最后一个节点
        Node nextNode = headNode;
        while (true) {
            if (nextNode.next == null) {
                break;
            }
            nextNode = nextNode.next;
        }
        nextNode.next = node;

    }

    public void show(){
        Node node =headNode.next;
        while (true){
            if(node == null){
                break;
            }else {
                System.out.println(node.toString());
                node = node.next;
            }
        }
    }

    public void delete(int no){
        Node nextNode = headNode;
        while (true) {
            if (nextNode.next == null) {
                break;
            }
            if(nextNode.next.no == no){
                nextNode.next = nextNode.next.next;
                return;
            }
            nextNode = nextNode.next;
        }
    }


    public void update(int no,String name){
        Node nextNode = headNode;
        while (true) {
            if (nextNode.next == null) {
                break;
            }
            if(nextNode.next.no == no){
                nextNode.next.name = name;
                return;
            }
            nextNode = nextNode.next;
        }
    }

    public void addByNo(Node node){
        Node nextNode = headNode;
        while (true) {
            if (nextNode.next == null) {
                nextNode.next = node;
                break;
            }
            if(nextNode.next.no > node.no){
                node.next = nextNode.next;
                nextNode.next = node;
                return;
            }
            nextNode = nextNode.next;
        }
    }

    /**
     * 获取单链表的长度
     * @return
     */
    public int size(){
        Node temp = headNode.next;
        int length = 0;
        if(temp == null){
           return length;
        }
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }


    /**
     * 获取链表的倒数index的节点
     *
     * @param index
     * @return
     */
    public Node getNodeByListIndex(int index){
        int length = size();
        Node temp = headNode.next;
        if(temp == null){
            return null;
        }
        if(index <= 0 || index > length){
            return null;
        }
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 反转链表
     */
    public void serverLinkedList(){
        if(headNode.next == null){
            return;
        }
        Node serverHeadNode = new Node(-1, "反转链表临时的头结点");
        Node temp = headNode.next;
        //serverHeadNode.next = temp;
        Node next = null;
        while (temp != null){
            //遍历取下链表的节点,拼接在反转链表的前一个位置
            next = temp.next;
            temp.next = serverHeadNode.next;
            serverHeadNode.next = temp;
            temp = next;
        }
        headNode.next = serverHeadNode.next;
    }
}


/**
 * 链表的基础元素
 *
 */
class Node{
    public int no;

    public String name;

    public Node next;

    public Node(int no,String name){
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}



