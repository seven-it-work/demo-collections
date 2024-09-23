package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1124Test {
    @Test
    void test1() {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        Assertions.assertEquals(3, Solution1124.longestWPI(hours));
    }

    @Test
    void test1_2() {
        int[] hours = {9, 9, 0, 0, 6, 0, 10, 6, 9, 9, 9, 9, 6, 6, 6};
        Assertions.assertEquals(13, Solution1124.longestWPI(hours));
    }

    @Test
    void test1_1() {
        int[] hours = {9, 9, 6, 0, 6, 9, 9};
        Assertions.assertEquals(7, Solution1124.longestWPI(hours));
    }

    @Test
    void test2() {
        int[] hours = {6, 6, 6};
        Assertions.assertEquals(0, Solution1124.longestWPI(hours));
    }

    @Test
    void test3() {
        int[] hours = {6, 6, 9};
        Assertions.assertEquals(1, Solution1124.longestWPI(hours));
    }

    @Test
    void test4() {
        int[] hours = {9, 9, 9};
        Assertions.assertEquals(3, Solution1124.longestWPI(hours));
    }

    @Test
    void test5() {
        int[] hours = {6, 9, 9};
        Assertions.assertEquals(3, Solution1124.longestWPI(hours));
    }

    @Test
    void test6() {
        int[] hours = {6, 6, 6, 6, 9, 9};
        Assertions.assertEquals(3, Solution1124.longestWPI(hours));
    }

    @Test
    void test7() {
        int[] hours = {9, 6, 9};
        Assertions.assertEquals(3, Solution1124.longestWPI(hours));
    }

    @Test
    void test8() {
        int[] hours = {8, 12, 7, 6, 10, 10, 9, 11, 12, 6};
        Assertions.assertEquals(10, Solution1124.longestWPI(hours));
    }

}