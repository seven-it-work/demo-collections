package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * #### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)
 * <p>
 * 难度中等1547收藏分享切换为英文接收动态反馈
 * <p>
 * 给你一个由 `'1'`（陆地）和 `'0'`（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * *示例 1：**
 * <p>
 * ```
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * ```
 * <p>
 * *示例 2：**
 * <p>
 * ```
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * ```
 * <p>
 * <p>
 * <p>
 * *提示：**
 * <p>
 * - `m == grid.length`
 * - `n == grid[i].length`
 * - `1 <= m, n <= 300`
 * - `grid[i][j]` 的值为 `'0'` 或 `'1'`
 * <p>
 * 通过次数397,853
 * <p>
 * 提交次数700,018
 *
 * 执行用时：7 ms, 在所有 Java 提交中击败了16.90%的用户
 * 内存消耗：49.6 MB, 在所有 Java 提交中击败了15.86%的用户
 */
public class Solution200Date20220219 {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    find(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    List<int[]> direction = Arrays.asList(new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});

    private void find(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        for (int[] ints : direction) {
            int x = i + ints[0];
            int y = j + ints[1];
            if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length) {
                if (grid[x][y] == '1') {
                    find(grid, x, y);
                }
            }
        }
    }

}
