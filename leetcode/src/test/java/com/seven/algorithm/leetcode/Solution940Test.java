package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution940Test {
    @Test
    void test1() {
        String s = "abc";
        Assertions.assertEquals(7, Solution940.distinctSubseqII(s));
    }

    @Test
    void test2() {
        String s = "aba";
        Assertions.assertEquals(6, Solution940.distinctSubseqII(s));
    }

    @Test
    void test3() {
        String s = "aaa";
        Assertions.assertEquals(3, Solution940.distinctSubseqII(s));
    }

    @Test
    void test4() {
        String s = "abcb";
        Assertions.assertEquals(13, Solution940.distinctSubseqII(s));
    }
    @Test
    void test5() {
        String s = "pcrdhwdxmqdznbenhwjsenjhvulyve";
        Assertions.assertEquals(836817663, Solution940.distinctSubseqII(s));
    }
}