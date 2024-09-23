package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1032Test {
    @Test
    void test1() {
        Solution1032.StreamChecker streamChecker = new Solution1032.StreamChecker(new String[] {"cd", "f", "kl"});
        Assertions.assertFalse(streamChecker.query('a'));
        Assertions.assertFalse(streamChecker.query('b'));
        Assertions.assertFalse(streamChecker.query('c'));
        Assertions.assertTrue(streamChecker.query('d'));
        Assertions.assertFalse(streamChecker.query('e'));
        Assertions.assertTrue(streamChecker.query('f'));
        Assertions.assertFalse(streamChecker.query('g'));
        Assertions.assertFalse(streamChecker.query('h'));
        Assertions.assertFalse(streamChecker.query('i'));
        Assertions.assertFalse(streamChecker.query('j'));
        Assertions.assertFalse(streamChecker.query('k'));
        Assertions.assertTrue(streamChecker.query('l'));
    }

}