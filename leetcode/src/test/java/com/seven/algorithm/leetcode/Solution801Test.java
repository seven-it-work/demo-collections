package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution801Test {
    @Test
    void test1() {
        int[] nums1 = {1, 2, 3, 8}, nums2 = {5, 6, 7, 4};
        int result = 1;
        Assertions.assertEquals(result, Solution801NO.minSwap(nums1, nums2));
    }
}