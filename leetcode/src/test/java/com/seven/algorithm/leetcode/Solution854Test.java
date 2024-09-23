package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution854Test {
    @Test
    void test01() {
        String s1 = "ab", s2 = "ba";
        Assertions.assertEquals(1, Solution854.kSimilarityMyNoPass(s1, s2));
    }

    @Test
    void test02() {
        String s1 = "abc", s2 = "bca";
        Assertions.assertEquals(2, Solution854.kSimilarityMyNoPass(s1, s2));
    }

    @Test
    void test03() {
        String s1 = "abcd", s2 = "abcd";
        Assertions.assertEquals(0, Solution854.kSimilarityMyNoPass(s1, s2));
    }

    @Test
    void test04() {
        String s1 = "abcd", s2 = "bacd";
        Assertions.assertEquals(1, Solution854.kSimilarityMyNoPass(s1, s2));
    }
    @Test
    void test05() {
        String s1 = "abac", s2 = "baca";
        Assertions.assertEquals(2, Solution854.kSimilarityMyNoPass(s1, s2));
    }
    @Test
    void test06() {
        String s1 = "ababab", s2 = "bababa";
        Assertions.assertEquals(1, Solution854.kSimilarityMyNoPass(s1, s2));
    }
    @Test
    void test07() {
        String s1 = "abcabc", s2 = "bcabca";
        Assertions.assertEquals(1, Solution854.kSimilarityMyNoPass(s1, s2));
    }
    @Test
    void test08() {
        String s1 = "abcabababc", s2 = "bcbabbcaaa";
        Assertions.assertEquals(4, Solution854.kSimilarityMyNoPass(s1, s2));
    }
}