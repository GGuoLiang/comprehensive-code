package com.guoliang.test;

import java.util.Arrays;

public class sortTest {


    public static void subQuickSort(int[] data, int strat,int end){
        if(strat < end){
            int base = data[strat];
            int low = strat;
            int higt = end+1;
            while (true){
                while (low < end && data[++low] - base <= 0){
                    ;
                }
                while (higt > strat && data[--higt] - base >= 0){
                    ;
                }
                if(low < higt){
                    swap(data,low,higt);
                }else{
                    break;
                }

            }
            swap(data,strat,higt);
            subQuickSort(data,strat,higt-1);
            subQuickSort(data,higt+1,end);
        }

    }

    public  static  void swap(int[] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void quickSort(int[] data){
        subQuickSort(data,0,data.length-1);
    }

    public static void main(String[] args) {
        int[] data = {1,44,56,3,6,2};
        System.out.println("排序之前："+ Arrays.toString(data));
        quickSort(data);
        System.out.println("排序之后："+Arrays.toString(data));

    }



}
