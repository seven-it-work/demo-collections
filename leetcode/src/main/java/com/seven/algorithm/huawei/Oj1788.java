/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.huawei;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author yijialuo
 * @since 2022/3/4 17:37
 */
public class Oj1788 {
    public static class Main {
        /**
         * main入口由OJ平台调用
         * AC！
         */
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
            int row = cin.nextInt();
            int stopPoint = cin.nextInt();
            int[][] operations = new int[row][2];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < 2; j++) {
                    operations[i][j] = cin.nextInt();
                }
            }
            cin.close();
            long result = getMinArea(stopPoint, operations);
            System.out.println(result);
        }

        // 待实现函数，在此函数中填入答题代码
        public static long getMinArea(int stopPoint, int[][] operations) {
            // 记录当前笔坐标
            long x = 0;
            long y = 0;
            long areaSum = 0;
            for (int[] operation : operations) {
                int moveX = operation[0];
                int moveY = operation[1];
                if (x == 0 && y == 0) {
                    x = moveX;
                    y += moveY;
                } else {
                    long kuan = Math.abs(moveX - x);
                    areaSum += kuan * Math.abs(y);
                    x = moveX;
                    y += moveY;
                }
            }
            if (x != stopPoint) {
                long kuan = Math.abs(stopPoint - x);
                areaSum += kuan * Math.abs(y);
            }
            return areaSum;
        }
    }
}
