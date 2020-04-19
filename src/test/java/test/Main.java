package test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author GGuoLiang
 * @Date 2020/4/18 4:36 下午
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        String next = scanner.next();
        String[] nextArray = next.split("、");
        if(nextArray.length < 3){
            return;
        }
        int intC = Integer.valueOf(nextArray[0]);
        int intB = Integer.valueOf(nextArray[1]);
        int temp ;
        int count = 0;
        for (int i = 2; i < nextArray.length; i++) {
            temp = Integer.valueOf(nextArray[i]);
            temp = splitInt(temp);
            if(temp%intB < intC){
                count++;
            }
        }
        System.out.println(count);
    }

    public static int  splitInt(int num) {
        byte[] ret= new byte[4];
        for(int i = 0;i < 4;++i) {
            ret[i] = (byte)(num>>(i*8));
        }
        System.out.println(Arrays.toString(ret));
        return combineIntoInt(ret);
    }

    public static int combineIntoInt(byte[] bytes) {
        int ret = 0;
        for(int i = 0;i < bytes.length;++i) {
            ret += bytes[i];
        }
        return ret;
    }
}
