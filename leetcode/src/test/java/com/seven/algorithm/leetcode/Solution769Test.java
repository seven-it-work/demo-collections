package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution769Test {
    @Test
    void test1() {
        int[] arr = {4, 3, 2, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }

    @Test
    void test2() {
        int[] arr = {1, 0, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }

    @Test
    void test3() {
        int[] arr = {1};
        int expected = 1;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }

    @Test
    void test4() {
        int[] arr = {1, 0, 2};
        int expected = 2;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }

    @Test
    void test5() {
        int[] arr = {2, 0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }
    @Test
    void test6() {
        int[] arr = {0, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }
    @Test
    void test7() {
        int[] arr = {1,2,0,3};
        int expected = 2;
        Assertions.assertEquals(expected, Solution769.maxChunksToSorted(arr));
    }
}