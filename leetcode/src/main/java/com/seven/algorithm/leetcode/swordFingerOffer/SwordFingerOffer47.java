/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode.swordFingerOffer;

/**
 * 剑指 Offer 47. 礼物的最大价值 https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 *
 * @date 2023/3/8 9:56
 */
public class SwordFingerOffer47 {
    public static int maxValue(int[][] grid) {
        return maxValue1(grid);
    }

    /**
     * 广度遍历
     * 时间 2 ms 击败 97.82% 内存 43.8 MB 击败 88.5%
     * 2023-3-8 10:15:01
     */
    private static int maxValue1(int[][] grid) {
        int[][] valueMap = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int value = getMax(valueMap, grid, i, j);
                valueMap[i][j] = value;
            }
        }
        return valueMap[grid.length - 1][grid[0].length - 1];
    }

    private static int getMax(int[][] valueMap, int[][] grid, int i, int j) {
        int value = grid[i][j];
        // 获取左边
        int left = value;
        if (i > 0) {
            left += valueMap[i - 1][j];
        }
        // 获取上班
        int right = value;
        if (j > 0) {
            right += valueMap[i][j - 1];
        }
        return Math.max(left, right);
    }
}
