package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution817Test {
    @Test
    void test1() {
        final Solution817.ListNode listNode = new Solution817.ListNode(0,
            new Solution817.ListNode(1, new Solution817.ListNode(2, new Solution817.ListNode(3))));
        int[] nums = {0, 1, 3};
        int result = 2;
        Assertions.assertEquals(result, Solution817.numComponents(listNode, nums));
    }

    @Test
    void test2() {
        final Solution817.ListNode listNode = new Solution817.ListNode(0,
            new Solution817.ListNode(1,
                new Solution817.ListNode(2, new Solution817.ListNode(3, new Solution817.ListNode(4)))));
        int[] nums = {0, 3, 1, 4};
        int result = 2;
        Assertions.assertEquals(result, Solution817.numComponents(listNode, nums));
    }

    @Test
    void test3() {
        final Solution817.ListNode listNode = new Solution817.ListNode(0);
        int[] nums = {0};
        int result = 1;
        Assertions.assertEquals(result, Solution817.numComponents(listNode, nums));
    }

    @Test
    void test4() {
        final Solution817.ListNode listNode = new Solution817.ListNode(0,
            new Solution817.ListNode(1, new Solution817.ListNode(2)));
        int[] nums = {1, 0};
        int result = 1;
        Assertions.assertEquals(result, Solution817.numComponents(listNode, nums));
    }
}