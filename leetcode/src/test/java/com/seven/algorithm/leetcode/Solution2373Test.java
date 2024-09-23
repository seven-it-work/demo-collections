package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2373Test {
    @Test
    void test1() {
        int[][] grid = {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}};
        Assertions.assertArrayEquals(new int[][] {{9, 9}, {8, 6}}, Solution2373.largestLocal(grid));
    }

}