package com.guoliang.algorithm.nowcoder.huawei;


import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author GGuoLiang
 * @Date 2020/4/17 1:14 下午
 * @Version 1.0
 *
 * 排序去重 TreeSet
 *
 */
public class Code3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0 ; i < num ;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }
    }

}
