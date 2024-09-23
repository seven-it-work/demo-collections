package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1357Test {
    @Test
    void test1() {
        int[] nums = {1, 5, 0, 3, 5};
        Assertions.assertEquals(3, Solution1357.minimumOperations(nums));
    }

    @Test
    void test2() {
        int[] nums = {0};
        Assertions.assertEquals(0, Solution1357.minimumOperations(nums));
    }
    @Test
    void test3() {
        int[] nums = {1};
        Assertions.assertEquals(1, Solution1357.minimumOperations(nums));
    }
    @Test
    void test4() {
        int[] nums = {1,1,1,2,2,2,3,3};
        Assertions.assertEquals(3, Solution1357.minimumOperations(nums));
    }
}