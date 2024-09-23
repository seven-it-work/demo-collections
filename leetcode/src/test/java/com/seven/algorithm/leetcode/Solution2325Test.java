package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2325Test {
    @Test
    void test1() {
        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";
        String except = "the five boxing wizards jump quickly";
        Assertions.assertEquals(except, Solution2325.decodeMessage(key, message));
    }
    @Test
    void test2() {
        String key  = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        String except = "this is a secret";
        Assertions.assertEquals(except, Solution2325.decodeMessage(key, message));
    }

}