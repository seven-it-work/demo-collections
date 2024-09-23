/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 2373. 矩阵中的局部最大值 <a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/description/">2373. 矩阵中的局部最大值</a>
 *
 * @date 2023/3/1 8:49
 */
public class Solution2373 {
    public static int[][] largestLocal(int[][] grid) {
        return largestLocal1(grid);
    }

    /**
     * 时间 2 ms 击败 100% 内存 42.6 MB 击败 35.55%
     * 2023-3-1 09:00:42
     */
    private static int[][] largestLocal1(int[][] grid) {
        int[][] gridTemp = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < gridTemp.length; i++) {
            for (int j = 0; j < gridTemp[i].length; j++) {
                gridTemp[i][j] = findMaxThreeXThree(grid, i, j);
            }
        }
        return gridTemp;
    }

    private static int findMaxThreeXThree(int[][] grid, int x, int y) {
        int max = 0;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                max = Math.max(grid[i][j], max);
            }
        }
        return max;
    }
}
