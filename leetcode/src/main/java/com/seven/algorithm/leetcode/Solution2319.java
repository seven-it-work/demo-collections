package com.seven.algorithm.leetcode;

public class Solution2319 {
    public static boolean checkXMatrix(int[][] grid) {
        return checkXMatrix1(grid);
    }

    /**
     * 2023-1-31 09:18:55
     * 时间 2 ms 击败 35.34% 内存 42.3 MB 击败 46.99%
     * 2023-1-31 09:39:53
     * @param grid
     * @return
     */
    private static boolean checkXMatrix1(int[][] grid) {
        int[] leftDiagonal = {0, 0};
        int[] rightDiagonal = {0, grid.length - 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == leftDiagonal[0] && j == leftDiagonal[1]) {
                    if (leftDiagonal[0] == rightDiagonal[0] && leftDiagonal[1] == rightDiagonal[1]) {
                        rightDiagonal[0] += 1;
                        rightDiagonal[1] -= 1;
                    }
                    leftDiagonal[0] += 1;
                    leftDiagonal[1] += 1;
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (i == rightDiagonal[0] && j == rightDiagonal[1]) {
                    rightDiagonal[0] += 1;
                    rightDiagonal[1] -= 1;
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
