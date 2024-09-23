package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2299Test {
    @Test
    void test1() {
        Assertions.assertTrue(Solution2299.strongPasswordCheckerII("IloveLe3tcode!"));
    }

    @Test
    void test2() {
        Assertions.assertFalse(Solution2299.strongPasswordCheckerII("Me+You--IsMyDream"));
    }

    @Test
    void test3() {
        Assertions.assertFalse(Solution2299.strongPasswordCheckerII("1aB!"));
    }
}