package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1626Test {
    @Test
    void test1() {
        int i = Solution1626.bestTeamScore(new int[] {4, 5, 6, 5}, new int[] {2, 1, 2, 1});
        Assertions.assertEquals(16, i);
    }

}