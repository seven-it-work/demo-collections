package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution902Test {
    @Test
    void test1() {
        String[] digits = {"1", "3", "5", "7"};
        int n = 100;
        Assertions.assertEquals(20, Solution902.atMostNGivenDigitSet(digits, n));
    }
    @Test
    void test1_1() {
        String[] digits = {"1", "3", "5", "7"};
        int n = 113;
        Assertions.assertEquals(22, Solution902.atMostNGivenDigitSet(digits, n));
    }

    @Test
    void test2() {
        String[] digits = {"1", "4", "9"};
        int n = 1000000000;
        Assertions.assertEquals(29523, Solution902.atMostNGivenDigitSet(digits, n));
    }

    @Test
    void test3() {
        String[] digits = {"7"};
        int n = 8;
        Assertions.assertEquals(1, Solution902.atMostNGivenDigitSet(digits, n));
    }

    @Test
    void test4() {
        String[] digits = {"7"};
        int n = 6;
        Assertions.assertEquals(0, Solution902.atMostNGivenDigitSet(digits, n));
    }
    @Test
    void test5() {
        String[] digits = {"3","4","5","6"};
        int n = 64;
        Assertions.assertEquals(18, Solution902.atMostNGivenDigitSet(digits, n));
    }
}