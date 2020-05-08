package com.gguoliang.algorithm.sort.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author GGuoLiang
 * @Date 2020/5/7 11:00 下午
 * @Version 1.0
 * <p>
 * 选择排序
 */
public class SelectSort {

    @Test
    public void test() {
        int[] array = {10, 11, -1, -2, 0, 34, 24};
        selectSort(array);
        System.out.println(Arrays.toString(array));

    }

    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int min = array[i];
            for (int i1 = 1 + i; i1 < array.length; i1++) {
                if (min > array[i1]) {
                    min = array[i1];
                    minIndex = i1;
                }
            }
            array[minIndex] = array[i];
            array[i] = min;
        }
    }
}
