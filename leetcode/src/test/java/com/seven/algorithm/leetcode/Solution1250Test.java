package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1250Test {
    @Test
    void test1() {
        int[] nums = {12, 5, 7, 23};
        Assertions.assertEquals(true, Solution1250.isGoodArray(nums));
    }

    @Test
    void test2() {
        int[] nums = {29, 6, 10};
        Assertions.assertEquals(true, Solution1250.isGoodArray(nums));
    }

    @Test
    void test3() {
        int[] nums = {3, 6};
        Assertions.assertEquals(false, Solution1250.isGoodArray(nums));
    }
}