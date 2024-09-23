package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution888Test {
    @Test
    void test1() {
        int[] ints = Solution888.fairCandySwap(new int[] {1, 1}, new int[] {2, 2});
        Assertions.assertArrayEquals(new int[] {1, 2}, ints);
    }

    @Test
    void test2() {
        int[] ints = Solution888.fairCandySwap(new int[] {1, 2}, new int[] {2, 3});
        Assertions.assertArrayEquals(new int[] {1, 2}, ints);
    }

    @Test
    void test3() {
        int[] ints = Solution888.fairCandySwap(new int[] {2}, new int[] {1, 3});
        Assertions.assertArrayEquals(new int[] {2, 3}, ints);
    }

    @Test
    void test4() {
        int[] ints = Solution888.fairCandySwap(new int[] {1, 2, 5}, new int[] {2, 4});
        Assertions.assertArrayEquals(new int[] {5, 4}, ints);
    }
}