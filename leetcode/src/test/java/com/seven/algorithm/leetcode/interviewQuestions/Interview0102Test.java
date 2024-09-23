package com.seven.algorithm.leetcode.interviewQuestions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Interview0102Test {
    @Test
    void test1() {
        String s1 = "abc", s2 = "bca";
        Assertions.assertTrue(Interview0102.CheckPermutation(s1, s2));
    }

    @Test
    void test2() {
        String s1 = "abc", s2 = "bad";
        Assertions.assertFalse(Interview0102.CheckPermutation(s1, s2));
    }
}