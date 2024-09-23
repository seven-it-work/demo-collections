package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1638Test {
    @Test
    void tes1() {
        Assertions.assertEquals(6, Solution1638.countSubstrings("aba", "baba"));
    }
    @Test
    void tes2() {
        Assertions.assertEquals(3, Solution1638.countSubstrings("ab", "bb"));
    }
    @Test
    void tes3() {
        Assertions.assertEquals(0, Solution1638.countSubstrings("a", "a"));
    }
    @Test
    void tes4() {
        Assertions.assertEquals(10, Solution1638.countSubstrings("abe", "bbc"));
    }

}