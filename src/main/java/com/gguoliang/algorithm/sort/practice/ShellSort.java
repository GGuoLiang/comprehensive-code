package com.gguoliang.algorithm.sort.practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author GGuoLiang
 * @Date 2020/5/8 9:50 下午
 * @Version 1.0
 * <p>
 * 希尔排序
 */
public class ShellSort {


    @Test
    public void test() {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        this.shellSortMove(array);
    }

    /**
     * 俩俩交换排序
     * @param array
     */
    public void shellSortExchange(int[] array) {
        for (int arg = array.length / 2; arg > 0; arg /= 2) {
            for (int i = arg; i < array.length; i++) {
                for (int j = i - arg; j >= 0; j -= arg) {
                    if (array[j] > array[j + arg]) {
                        int temp = array[j];
                        array[j] = array[j + arg];
                        array[j + arg] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 移位法
     */
    public void shellSortMove(int[] array){
        for (int arg = array.length / 2; arg > 0; arg /= 2) {
            for (int i = arg; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if(array[j] < array[j -arg]){
                    while (j-arg >= 0 && temp < array[j-arg]){
                        array[j] = array[j-arg];
                        j -= arg;
                    }
                    array[j] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void reasoning(int[] array) {
        for (int i = 5; i < array.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (array[j] > array[j + 5]) {
                    int temp = array[j];
                    array[j] = array[j + 5];
                    array[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮=" + Arrays.toString(array));

        for (int i = 2; i < array.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (array[j] > array[j + 2]) {
                    int temp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("第二轮=" + Arrays.toString(array));
    }

}
