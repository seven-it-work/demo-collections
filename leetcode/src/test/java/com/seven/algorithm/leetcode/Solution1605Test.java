package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1605Test {
    @Test
    void test1() {
        int[][] result = new int[][] {
            {5, 0, 0},
            {3, 4, 0},
            {0, 2, 8},
        };
        Assertions.assertArrayEquals(result, Solution1605.restoreMatrix(new int[] {5, 7, 10}, new int[] {8, 6, 8}));
    }

    @Test
    void test2() {
        int[][] result = new int[][] {
            {6, 8, 0},
            {0, 1, 8},
        };
        Assertions.assertArrayEquals(result, Solution1605.restoreMatrix(new int[] {14, 9}, new int[] {6, 9, 8}));
    }

}