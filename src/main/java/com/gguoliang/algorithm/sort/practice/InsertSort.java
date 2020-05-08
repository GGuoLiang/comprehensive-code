package com.gguoliang.algorithm.sort.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author GGuoLiang
 * @Date 2020/5/7 11:32 下午
 * @Version 1.0
 *
 * 插入排序
 *
 */
public class InsertSort {
    @Test
    public void test() {
        int[] array = {10, 11, -1, -2, 0, 34, 24};
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }

    public  void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i-1;
            while (insertIndex >= 0 && insertVal < array[insertIndex]){
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex+1] = insertVal;
        }
    }
}
