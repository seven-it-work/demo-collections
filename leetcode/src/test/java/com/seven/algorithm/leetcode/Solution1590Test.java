package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1590Test {
    @Test
    void test1() {
        Assertions.assertEquals(1, Solution1590.minSubarray(new int[] {3, 1, 4, 2}, 6));
    }

    @Test
    void test2() {
        Assertions.assertEquals(2, Solution1590.minSubarray(new int[] {6, 3, 5, 2}, 9));
    }

    @Test
    void test3() {
        Assertions.assertEquals(0, Solution1590.minSubarray(new int[] {1, 2, 3}, 3));
    }

    @Test
    void test4() {
        Assertions.assertEquals(-1, Solution1590.minSubarray(new int[] {1, 2, 3}, 7));
    }

    @Test
    void test5() {
        Assertions.assertEquals(0, Solution1590.minSubarray(new int[] {1000000000, 1000000000, 1000000000}, 3));
    }

    @Test
    void test6() {
        Assertions.assertEquals(7,
            Solution1590.minSubarray(new int[] {8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148));
    }

}