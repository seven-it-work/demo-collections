package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2319Test {
    @Test
    void test1() {
        int[][] ints = {{2, 0, 0, 1}, {0, 3, 1, 0}, {0, 5, 2, 0}, {4, 0, 0, 2}};
        Assertions.assertTrue(Solution2319.checkXMatrix(ints));
    }
    @Test
    void test2() {
        int[][] ints = {{5,0,20},{0,5,0},{6,0,2}};
        Assertions.assertTrue(Solution2319.checkXMatrix(ints));
    }

}