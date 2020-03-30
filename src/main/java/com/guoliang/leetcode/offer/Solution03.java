package com.guoliang.leetcode.offer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author GGuoLiang
 * @Date 2020/3/27 10:01 上午
 * @Version 1.0
 *
 *
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *  
 *
 * 限制：
 *
 * 2 <= n <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：使用Hashset 不重复的特性
 *
 */
public class Solution03 {

    public  int  findRepeatNumber(int[] num){
        int temp = -1;
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if (!integerSet.add(num[i])) {
                temp = num[i];
                break;
            }
        }
        return temp;
    }



    @Test
    public void test1(){
        int[] num = {1,2,3,4,4,4,5,2};
        System.out.println(findRepeatNumber(num));
    }
}
