package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1234Test {
    @Test
    void test1() {
        String s = "QWER";
        int except = 0;
        Assertions.assertEquals(except, Solution1234.balancedString(s));
    }

    @Test
    void test2() {
        String s = "QQWE";
        int except = 1;
        Assertions.assertEquals(except, Solution1234.balancedString(s));
    }

    @Test
    void test3() {
        String s = "QQQW";
        int except = 2;
        Assertions.assertEquals(except, Solution1234.balancedString(s));
    }

    @Test
    void test4() {
        String s = "QQQQ";
        int except = 3;
        Assertions.assertEquals(except, Solution1234.balancedString(s));
    }
    @Test
    void test5() {
        String s = "WWEQERQWQWWRWWERQWEQ";
        int except = 4;
        Assertions.assertEquals(except, Solution1234.balancedString(s));
    }
}