package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution1Test {
    @Test
    void test1() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = {0, 1};
        Assertions.assertArrayEquals(Arrays.stream(result).sorted().toArray(),
            Arrays.stream(Solution1.twoSum(nums, target)).sorted().toArray());
    }
    @Test
    void test2() {
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = {1,2};
        Assertions.assertArrayEquals(Arrays.stream(result).sorted().toArray(),
            Arrays.stream(Solution1.twoSum(nums, target)).sorted().toArray());
    }
}