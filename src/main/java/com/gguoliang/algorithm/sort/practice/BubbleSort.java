package com.gguoliang.algorithm.sort.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author GGuoLiang
 * @Date 2020/5/7 10:29 下午
 * @Version 1.0
 * <p>
 * 冒泡排序
 * 时间复杂度 O(n^2)
 */
public class BubbleSort {


    @Test
    public void test() {
        int[] array = {10, 11, -1, -2, 0, 34, 24};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int i1 = 0; i1 < array.length - 1 - i; i1++) {
                if (array[i1] > array[i1 + 1]) {
                    int temp = array[i1 + 1];
                    array[i1 + 1] = array[i1];
                    array[i1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
