package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution915Test {
    @Test
    void test1() {
        int[] nums = {5, 0, 3, 8, 6};
        Assertions.assertEquals(3, Solution915.partitionDisjoint(nums));
    }

    @Test
    void test2() {
        int[] nums = {5, 4, 3, 8, 6};
        Assertions.assertEquals(3, Solution915.partitionDisjoint(nums));
    }

    @Test
    void test3() {
        int[] nums = {5, 6, 3, 8, 7};
        Assertions.assertEquals(3, Solution915.partitionDisjoint(nums));
    }

    @Test
    void test4() {
        int[] nums = {5, 7, 3, 7, 8};
        Assertions.assertEquals(3, Solution915.partitionDisjoint(nums));
    }

    @Test
    void test5() {
        int[] nums = {1, 1, 1, 0, 6, 12};
        Assertions.assertEquals(4, Solution915.partitionDisjoint(nums));
    }

    @Test
    void test6() {
        int[] nums = {1, 1};
        Assertions.assertEquals(1, Solution915.partitionDisjoint(nums));
    }

    @Test
    void test7() {
        int[] nums = {29, 33, 6, 4, 42, 0, 10, 22, 62, 16, 46, 75, 100, 67, 70, 74, 87, 69, 73, 88};
        Assertions.assertEquals(11, Solution915.partitionDisjoint(nums));
    }
}