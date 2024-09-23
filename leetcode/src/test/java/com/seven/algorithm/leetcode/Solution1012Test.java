package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1012Test {
    @Test
    void test1() {
        Assertions.assertEquals(1, Solution1012.numDupDigitsAtMostN(20));
    }

    @Test
    void test2() {
        Assertions.assertEquals(10, Solution1012.numDupDigitsAtMostN(100));
    }

    @Test
    void test3() {
        Assertions.assertEquals(262, Solution1012.numDupDigitsAtMostN(1000));
    }

    @Test
    void test4() {
        Assertions.assertEquals(262, Solution1012.numDupDigitsAtMostN(Integer.MAX_VALUE));
    }

}