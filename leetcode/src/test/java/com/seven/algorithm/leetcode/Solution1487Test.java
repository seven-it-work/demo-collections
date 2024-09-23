package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1487Test {
    @Test
    void test1() {
        String[] names = {"pes", "fifa", "gta", "pes(2019)"};
        String[] except = {"pes", "fifa", "gta", "pes(2019)"};
        Assertions.assertArrayEquals(except, Solution1487.getFolderNames(names));
    }

    @Test
    void test3() {
        String[] names = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        String[] except = {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"};
        Assertions.assertArrayEquals(except, Solution1487.getFolderNames(names));
    }

    @Test
    void test4() {
        String[] names = {"wano", "wano", "wano", "wano"};
        String[] except = {"wano", "wano(1)", "wano(2)", "wano(3)"};
        Assertions.assertArrayEquals(except, Solution1487.getFolderNames(names));
    }
    @Test
    void test5() {
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)"};
        String[] except = {"kaido","kaido(1)","kaido(2)","kaido(1)(1)"};
        Assertions.assertArrayEquals(except, Solution1487.getFolderNames(names));
    }
    @Test
    void test6() {
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)","kaido(1)"};
        String[] except = {"kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(1)(2)"};
        Assertions.assertArrayEquals(except, Solution1487.getFolderNames(names));
    }
    @Test
    void test7() {
        String[] names = {"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"};
        String[] except = {"kaido","kaido(1)","kaido(2)","kaido(1)(1)","kaido(2)(1)"};
        Assertions.assertArrayEquals(except, Solution1487.getFolderNames(names));
    }
}