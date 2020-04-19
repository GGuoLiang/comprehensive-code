package com.gguoliang.algorithm.nowcoder.huawei;

import java.util.Scanner;

/**
 * @Author GGuoLiang
 * @Date 2020/4/17 11:27 上午
 * @Version 1.0
 *
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class Code2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            String c = scanner.next();
            solution( s=s.toUpperCase(),c.toUpperCase().charAt(0));
        }
    }

    public static void solution(String str,char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(c == str.charAt(i)){
                count++;
            }
        }
        System.out.println(count);

    }
}
