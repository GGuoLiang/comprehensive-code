package com.gguoliang.dataStructures.stack;

import lombok.Data;
import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/4/24 9:26 上午
 * @Version 1.0
 * <p>
 * 基于数组实现的栈
 * 1.栈顶top 默认初始值为-1
 * 2.入栈：top++，stack[top] = data
 * 3.出栈：data = stack[top],top--
 * 4.判断栈满：top == maxSize-1
 * 5.判断栈空：top == -1
 */
@Data
public class ArrayStack {

    /**
     * 栈顶
     */
    private int top;
    /**
     * 栈
     */
    private int[] stack;

    /**
     * 最大容量
     */
    private int maxSize;

    public ArrayStack() {

    }

    public ArrayStack(int maxSize) {
        top = -1;
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
    }

    /**
     * 入栈操作
     *
     * @param data
     */
    public void push(int data) {
        //判断是否已经栈满
        if (isFull()) {
            System.out.println("该栈已满。。。。。。。");
            return;
        }
        stack[++top] = data;
    }

    /**
     * 出栈操作
     *
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("该栈已空。。。。。。。");
            return -1;
        }
        return stack[top--];
    }


    /**
     * 栈满判断
     *
     * @return
     */
    public Boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空判断
     *
     * @return
     */
    public Boolean isEmpty() {
        return top == -1;
    }

    /**
     * 获取栈顶的元素
     *
     * @return
     */
    public char peek() {
        return (char) stack[top];
    }


    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push('*');
        System.out.println(arrayStack.pop() + "top " + arrayStack.getTop());
    }
}
