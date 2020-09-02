package com.gguoliang.dataStructures.recursive;

import org.junit.Test;

/**
 * @Author GGuoLiang
 * @Date 2020/5/2 9:02 上午
 * @Version 1.0
 *
 * 迷宫问题
 *
 */
public class MiGong {

    public void setWay(){

    }

    @Test
    public void test(){
        // 创建棋盘
        int[][] map = new int[8][7];
        // 四边设置墙  值为1
        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[6][i] = 1;
        }

        for (int i = 0; i < 7; i++) {
            map[i][1] = 1;
            map[i][6] = 1;
        }

    }


}
