package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1652Test {
    @Test
    void test1() {
        int[] code = {5, 7, 1, 4};
        int k = 3;
        int[] result = {12, 10, 16, 13};
        Assertions.assertArrayEquals(result, Solution1652.decrypt(code, k));
    }

    @Test
    void test2() {
        int[] code = {1, 2, 3, 4};
        int k = 0;
        int[] result = {0, 0, 0, 0};
        Assertions.assertArrayEquals(result, Solution1652.decrypt(code, k));
    }

    @Test
    void test3() {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        int[] result = {12, 5, 6, 13};
        Assertions.assertArrayEquals(result, Solution1652.decrypt(code, k));
    }
}