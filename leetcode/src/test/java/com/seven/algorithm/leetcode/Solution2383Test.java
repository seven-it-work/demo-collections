package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2383Test {
    @Test
    void test1() {
        Assertions.assertEquals(8, Solution2383.minNumberOfHours(5, 3, new int[] {1, 4, 3, 2}, new int[] {2, 6, 3, 1}));
    }

    @Test
    void test2() {
        Assertions.assertEquals(650, Solution2383.minNumberOfHours(94, 70,
            new int[] {58, 47, 100, 71, 47, 6, 92, 82, 35, 16, 50, 15, 42, 5, 2, 45, 22},
            new int[] {77, 83, 99, 76, 75, 66, 58, 84, 44, 98, 70, 41, 48, 7, 10, 61, 28}));
    }

}