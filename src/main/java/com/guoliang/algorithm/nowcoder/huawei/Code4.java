package com.guoliang.algorithm.nowcoder.huawei;

import java.util.Objects;
import java.util.Scanner;

/**
 * @Author GGuoLiang
 * @Date 2020/4/17 2:09 下午
 * @Version 1.0
 */
public class Code4 {

    public static void main(String[] args) {
        Objects.equals("A","B");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            if(next.length()%8 != 0){
                next = next+"00000000";
            }
            while (next.length() >=8 ){
                System.out.println(next.substring(0,8));
                next = next.substring(8);
            }
        }

    }
}
