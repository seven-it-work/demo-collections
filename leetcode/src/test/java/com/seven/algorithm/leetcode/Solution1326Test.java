package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1326Test {
    @Test
    void test1() {
        int[] ranges = {3, 3, 1, 1, 0, 0};
        Assertions.assertEquals(1, Solution1326.minTaps(5, ranges));
    }

}