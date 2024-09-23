package com.seven.algorithm;

import com.seven.algorithm.leetcode.Solution1144;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1144Test {
    @Test
    void test1() {
        int[] nums = {1, 2, 3};
        Assertions.assertEquals(2, Solution1144.movesToMakeZigzag(nums));
    }

    @Test
    void test2() {
        int[] nums = {9, 6, 1, 6, 2};
        Assertions.assertEquals(4, Solution1144.movesToMakeZigzag(nums));
    }

    @Test
    void test3() {
        int[] nums = {1, 2, 1};
        Assertions.assertEquals(0, Solution1144.movesToMakeZigzag(nums));
    }

    @Test
    void test4() {
        int[] nums = {2, 7, 10, 9, 8, 9};
        Assertions.assertEquals(4, Solution1144.movesToMakeZigzag(nums));
    }

    @Test
    void test5() {
        int[] nums = {7, 4, 8, 9, 7, 7, 5};
        Assertions.assertEquals(6, Solution1144.movesToMakeZigzag(nums));
    }

    @Test
    void test6() {
        int[] nums = {10, 1, 1, 6, 6, 6, 1, 8, 8, 5, 1, 2, 6, 6, 6, 4, 4, 8, 7, 1};
        Assertions.assertEquals(32, Solution1144.movesToMakeZigzag(nums));
    }
}