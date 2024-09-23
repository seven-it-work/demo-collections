package com.seven.algorithm.leetcode.interviewQuestions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Interview1709Test {

    @Test
    void test1() {
        Assertions.assertEquals(9, Interview1709NO.getKthMagicNumber(5));
    }

    @Test
    void test2() {
        Assertions.assertEquals(1, Interview1709NO.getKthMagicNumber(1));
    }

    @Test
    void test3() {
        Assertions.assertEquals(3, Interview1709NO.getKthMagicNumber(2));
    }
    @Test
    void test5() {
        Assertions.assertEquals(3215625, Interview1709NO.getKthMagicNumber(251));
    }
}