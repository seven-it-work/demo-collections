package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2347Test {
    @Test
    void test1() {
        int[] ranks = {13, 2, 3, 1, 9};
        char[] suits = {'a', 'a', 'a', 'a', 'a'};
        Assertions.assertEquals("Flush", Solution2347.bestHand(ranks, suits));
    }

    @Test
    void test2() {
        int[] ranks = {4, 4, 2, 4, 4};
        char[] suits = {'d', 'a', 'a', 'b', 'c'};
        Assertions.assertEquals("Three of a Kind", Solution2347.bestHand(ranks, suits));
    }

    @Test
    void test3() {
        int[] ranks = {10, 10, 2, 12, 9};
        char[] suits = {'a', 'b', 'c', 'a', 'd'};
        Assertions.assertEquals("Pair", Solution2347.bestHand(ranks, suits));
    }

}