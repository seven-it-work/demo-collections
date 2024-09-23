package com.seven.algorithm.leetcode.interviewQuestions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Interview0109Test {
    @Test
    void test1() {
        String s1 = "waterbottle", s2 = "erbottlewat";
        Assertions.assertTrue(Interview0109.isFlipedString(s1, s2));
    }

    @Test
    void test2() {
        String s1 = "aa", s2 = "aba";
        Assertions.assertFalse(Interview0109.isFlipedString(s1, s2));
    }
}