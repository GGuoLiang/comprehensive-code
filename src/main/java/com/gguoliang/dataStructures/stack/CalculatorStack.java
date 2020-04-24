package com.gguoliang.dataStructures.stack;

import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;

/**
 * @Author GGuoLiang
 * @Date 2020/4/24 9:47 上午
 * @Version 1.0
 *
 * 用栈实现计算器
 * 1.需要俩个栈 一个为数字栈，一个为符号栈
 * 2.逐个判断字符是数字还是字符
 * 3.1push符号栈 当前当前栈为空 直接入栈;
 * 3.2不为空，判断判断栈顶元素和当前字符的优先级，
 * 当前符号的优先级低于栈顶的元素符号的优先级时，顺序出数字栈栈顶俩个元素和一个符号栈栈顶符号进行运算
 * 4.表达式全部入栈完成，开始顺序出栈做运算操作
 * 5.数值栈的最后一个出栈元素为结果值
 *
 */
public class CalculatorStack {
    /**
     * 字符集合
     */
    private char[] chars = {'*','/','+','-'};
    /**
     * 数字栈
     */
    private ArrayStack numStack;
    /**
     * 符号栈
     */
    private ArrayStack symbolStack;

    public CalculatorStack(ArrayStack numStack, ArrayStack symbolStack) {
        this.numStack = numStack;
        this.symbolStack = symbolStack;
    }

    /**
     * 计算输入的运算符
     * @param str
     * @return
     */
    public int calculate(String str) {
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length; i++) {
            if (isSymbol(toCharArray[i])) {
                if (symbolStack.isEmpty()) {
                    symbolStack.push(toCharArray[i]);
                } else {
                    // 当前符号的优先级低于栈顶的优先级
                    while (!symbolStack.isEmpty() && priority(toCharArray[i], symbolStack.peek()) <= 0) {
                        //对栈顶的操作符做运算
                        int subCalculate = subCalculate(numStack.pop(), numStack.pop(), (char) symbolStack.pop());
                        numStack.push(subCalculate);
                    }
                    symbolStack.push(toCharArray[i]);
                }
            } else {
                String temp = String.valueOf(toCharArray[i]);
                while (i < toCharArray.length-1 && !isSymbol(toCharArray[i+1])){
                    temp = temp + toCharArray[i+1];
                    i++;
                }
                numStack.push(Integer.valueOf(temp));
            }

        }
        while (true){
            if(symbolStack.isEmpty()){
                break;
            }
            int subCalculate = subCalculate(numStack.pop(), numStack.pop(), (char) symbolStack.pop());
            numStack.push(subCalculate);
        }
        return numStack.pop();
    }

    /**
     * 判断当前字符是否符号
     * @param ch
     * @return
     */
    public Boolean isSymbol(char ch){
        for (char aChar : chars) {
            if(ch == aChar){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断当前符号和栈顶符号的优先级
     * @param c1 即将入栈的符号
     * @param c2 栈顶符号
     * @return 大于0 c1 优先级高 小于零 c2 优先级高
     */
    public int priority(char c1,char c2){
        return priorityNum(c1) - priorityNum(c2);
    }

    /**
     * 获取符号的优先级数
     * @param c
     * @return
     */
    public int priorityNum(char c){
        int num = 0;
       switch (c){
           case '*':num = 2;  break;
           case '/':num = 2;  break;
           case '-':num = 1;  break;
           case '+':num = 1;  break;
           default : ;
       }
       return num;
    }

    public int subCalculate(int num1,int num2,char c){
        int num = 0;
        switch (c){
            case '*':num = num1*num2;  break;
            case '/':num = num2/num1;  break;
            case '-':num = num2-num1;  break;
            case '+':num = num1+num2;  break;
            default : ;
        }
        return num;
    }


    public static void main(String[] args) {
        CalculatorStack calculatorStack = new CalculatorStack(new ArrayStack(10),new ArrayStack(10));
        String str = "13*4-5*6-7-9-9";
        System.out.println(calculatorStack.calculate(str));

    }
}
