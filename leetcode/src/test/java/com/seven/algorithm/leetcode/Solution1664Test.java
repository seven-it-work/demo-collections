package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution1664Test {
    @Test
    void test0() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7};
        Assertions.assertEquals(0, Solution1664.waysToMakeFair(nums));
    }

    @Test
    void test1() {
        int[] nums = {2, 1, 6, 4};
        Assertions.assertEquals(1, Solution1664.waysToMakeFair(nums));
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 1};
        Assertions.assertEquals(3, Solution1664.waysToMakeFair(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(0, Solution1664.waysToMakeFair(nums));
    }
}