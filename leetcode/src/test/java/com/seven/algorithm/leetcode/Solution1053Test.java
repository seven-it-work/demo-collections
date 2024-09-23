package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1053Test {
    @Test
    void test1() {
        int[] ints = Solution1053.prevPermOpt1(new int[] {3, 2, 1});
        Assertions.assertArrayEquals(new int[] {3, 1, 2}, ints);
    }
    @Test
    void test2() {
        int[] ints = Solution1053.prevPermOpt1(new int[] {1,9,4,6,7});
        Assertions.assertArrayEquals(new int[] {1,7,4,6,9}, ints);
    }
    @Test
    void test3() {
        int[] ints = Solution1053.prevPermOpt1(new int[] {3,1,1,3});
        Assertions.assertArrayEquals(new int[] {1,3,1,3}, ints);
    }

}