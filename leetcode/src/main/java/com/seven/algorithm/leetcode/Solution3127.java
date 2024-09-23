package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

import java.util.Arrays;

public class Solution3127 {
    public static void main(String[] args) {
        System.out.println(new Solution3127().canMakeSquare(TransformUtils.charTwoDimensionalArrays(
            "[[\"B\",\"W\",\"B\"],[\"B\",\"W\",\"W\"],[\"B\",\"W\",\"B\"]]")));// true
        System.out.println(new Solution3127().canMakeSquare(TransformUtils.charTwoDimensionalArrays(
            "[[\"B\",\"W\",\"B\"],[\"W\",\"B\",\"W\"],[\"B\",\"W\",\"B\"]]")));// false
        System.out.println(new Solution3127().canMakeSquare(TransformUtils.charTwoDimensionalArrays(
            "[[\"B\",\"W\",\"B\"],[\"B\",\"W\",\"W\"],[\"B\",\"W\",\"W\"]]")));// true
    }

    /**
     * 2024-8-31 10:47:18
     * 思路：通过遍历0,0 0,1 1,0 1,1 这些索引，以这些索引为顶点找到2x2的正方形是否有>=3个黑色 或者>=3个白色 有就return true
     * 2024-8-31 10:56:17
     * @param grid
     * @return
     */
    public boolean canMakeSquare(char[][] grid) {
        // System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < grid.length - 1; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length - 1; j++) {
                int bCount = 0;
                int wCount = 0;
                // System.out.println(i + "," + j + ":" + grid[i][j]);
                // 判断2x2
                if (grid[i][j] == 'B') {
                    bCount++;
                } else if (grid[i][j] == 'W') {
                    wCount++;
                }
                if (grid[i + 1][j] == 'B') {
                    bCount++;
                } else if (grid[i + 1][j] == 'W') {
                    wCount++;
                }
                if (grid[i][j + 1] == 'B') {
                    bCount++;
                } else if (grid[i][j + 1] == 'W') {
                    wCount++;
                }
                if (grid[i + 1][j + 1] == 'B') {
                    bCount++;
                } else if (grid[i + 1][j + 1] == 'W') {
                    wCount++;
                }
                if (bCount >= 3 || wCount >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
