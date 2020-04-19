package com.guoliang.interviewCode.huawei;

import java.util.Scanner;

/**
 * @Author GGuoLiang
 * @Date 2020/4/17 11:13 上午
 * @Version 1.0
 *
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 使用String函数的split 分隔成数组
 */
public class Code1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            solution(s);
        }

    }

    public static void solution(String str){
        String[] temp = str.split(" ");
        System.out.println(temp[temp.length-1].length());
    }

}
