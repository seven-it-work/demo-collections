package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2379Test {
    @Test
    void test1() {
        Assertions.assertEquals(3, Solution2379.minimumRecolors("WBBWWBBWBW", 7));
    }

    @Test
    void test2() {
        Assertions.assertEquals(0, Solution2379.minimumRecolors("WBWBBBW", 2));
    }

    @Test
    void test3() {
        Assertions.assertEquals(1, Solution2379.minimumRecolors("WBWW", 2));
    }

    @Test
    void test4() {
        Assertions.assertEquals(6, Solution2379.minimumRecolors("WWBBBWBBBBBWWBWWWB", 16));
    }

}