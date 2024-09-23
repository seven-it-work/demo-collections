package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2389Test {
    @Test
    void test1() {
        int[] ints = Solution2389.answerQueries(new int[] {4, 5, 2, 1}, new int[] {3, 10, 21});
        Assertions.assertArrayEquals(new int[] {2, 3, 4}, ints);
    }
}