package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class Solution1814Test {
    @Test
    void test1() {
        int[] ints = new int[] {42, 11, 1, 97};
        int expectations = 2;
        int result = Solution1814.countNicePairs(ints);
        Assertions.assertEquals(expectations, result);
    }

    @Test
    void test2() {
        int[] ints = new int[] {13, 10, 35, 24, 76};
        int expectations = 4;
        int result = Solution1814.countNicePairs(ints);
        Assertions.assertEquals(expectations, result);
    }

    @Nested
    class TestRev {
        @Test
        void test1() {
            Assertions.assertEquals(1, Solution1814.rev2(1));
        }

        @Test
        void test2() {
            Assertions.assertEquals(1, Solution1814.rev2(10));
        }

        @Test
        void test3() {
            Assertions.assertEquals(101, Solution1814.rev2(101));
        }
    }

}