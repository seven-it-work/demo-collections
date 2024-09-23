package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1640Test {
    @Test
    void test1() {
        int[] arr = {15, 88};
        int[][] pieces = {{88}, {15}};
        Assertions.assertTrue(Solution1640.canFormArrayMyAC(arr, pieces));
    }

    @Test
    void test2() {
        int[] arr = {49, 18, 16};
        int[][] pieces = {{16, 18, 49}};
        Assertions.assertFalse(Solution1640.canFormArrayMyAC(arr, pieces));
    }

    @Test
    void test3() {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        Assertions.assertTrue(Solution1640.canFormArrayMyAC(arr, pieces));
    }
    @Test
    void test4() {
        int[] arr = {1, 1, 1, 1};
        int[][] pieces = {{1}, {1, 1}, {1}};
        Assertions.assertTrue(Solution1640.canFormArrayMyAC(arr, pieces));
    }
    @Test
    void test5() {
        int[] arr = {12};
        int[][] pieces = {{1}};
        Assertions.assertFalse(Solution1640.canFormArrayMyAC(arr, pieces));
    }
}