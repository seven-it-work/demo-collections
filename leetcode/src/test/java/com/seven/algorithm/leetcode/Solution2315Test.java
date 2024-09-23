package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2315Test {
    @Test
    void test1() {
        String s = "l|*e*et|c**o|*de|";
        Assertions.assertEquals(2, Solution2315.countAsterisks(s));
    }

    @Test
    void test2() {
        String s = "l123123123";
        Assertions.assertEquals(0, Solution2315.countAsterisks(s));
    }

    @Test
    void test3() {
        String s = "yo|uar|e**|b|e***au|tifu|l";
        Assertions.assertEquals(5, Solution2315.countAsterisks(s));
    }
}