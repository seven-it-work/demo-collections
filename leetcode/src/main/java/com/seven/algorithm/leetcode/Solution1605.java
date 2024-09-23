/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 1605. 给定行和列的和求可行矩阵 <a href="https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/submissions/413073426/">...</a>
 *
 * @date 2023/3/14 14:14
 */
public class Solution1605 {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        return restoreMatrix1(rowSum, colSum);
    }

    /**
     * 时间 3 ms 击败 68.70% 内存 49.6 MB 击败 12.97%
     * 2023-3-14 14:48:24
     *
     * @param rowSum
     * @param colSum
     * @return
     */
    private static int[][] restoreMatrix1(int[] rowSum, int[] colSum) {
        int[][] ints = new int[rowSum.length][colSum.length];
        int rowIndex = 0;
        int colIndex = 0;
        while (rowIndex < rowSum.length && colIndex < colSum.length) {
            if (rowSum[rowIndex] < colSum[colIndex]) {
                ints[rowIndex][colIndex] = rowSum[rowIndex];
                for (int i = colIndex + 1; i < colSum.length; i++) {
                    ints[rowIndex][i] = 0;
                }
                colSum[colIndex] = colSum[colIndex] - rowSum[rowIndex];
                rowIndex++;
            } else {
                ints[rowIndex][colIndex] = colSum[colIndex];
                for (int i = rowIndex + 1; i < rowSum.length; i++) {
                    ints[i][colIndex] = 0;
                }
                rowSum[rowIndex] = rowSum[rowIndex] - colSum[colIndex];
                colIndex++;
            }
        }
        return ints;
    }
}
