package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2341Test {
    @Test
    void test1() {
        int[] nums = {1, 3, 2, 1, 3, 2, 2};
        int[] result = {3, 1};
        Assertions.assertArrayEquals(result, Solution2341.numberOfPairs(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 1};
        int[] result = {1, 0};
        Assertions.assertArrayEquals(result, Solution2341.numberOfPairs(nums));
    }
    @Test
    void test23() {
        int[] nums = {0};
        int[] result = {0, 1};
        Assertions.assertArrayEquals(result, Solution2341.numberOfPairs(nums));
    }
}