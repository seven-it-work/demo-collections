package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution779Test {
    @Test
    void test1() {
        int n = 1;
        int k = 1;
        Assertions.assertEquals(0, Solution779.kthGrammar(n, k));
    }
    @Test
    void test2() {
        int n = 2;
        int k = 1;
        Assertions.assertEquals(0, Solution779.kthGrammar(n, k));
    }
    @Test
    void test3() {
        int n = 2;
        int k =2;
        Assertions.assertEquals(1, Solution779.kthGrammar(n, k));
    }
    @Test
    void test4() {
        int n = 3;
        int k =1;
        Assertions.assertEquals(0, Solution779.kthGrammar(n, k));
    }
    @Test
    void test5() {
        int n = 3;
        int k =2;
        Assertions.assertEquals(1, Solution779.kthGrammar(n, k));
    }
    @Test
    void test6() {
        int n = 3;
        int k =3;
        Assertions.assertEquals(1, Solution779.kthGrammar(n, k));
    }
    @Test
    void test7() {
        int n = 30;
        int k =434991989;
        Assertions.assertEquals(0, Solution779.kthGrammar(n, k));
    }
    @Test
    void test8() {
        int n = 5;
        int k =15;
        Assertions.assertEquals(1, Solution779.kthGrammar(n, k));
    }
    @Test
    void test9() {
        int n = 6;
        int k =15;
        Assertions.assertEquals(1, Solution779.kthGrammar(n, k));
    }
}