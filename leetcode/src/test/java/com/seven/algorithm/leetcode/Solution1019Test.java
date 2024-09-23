package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1019Test {
    @Test
    void test1() {
        Solution1019.ListNode root = new Solution1019.ListNode(2);
        Solution1019.ListNode next = root;
        next.next = new Solution1019.ListNode(1);
        next = next.next;
        next.next = new Solution1019.ListNode(5);
        next = next.next;
        int[] ints = Solution1019.nextLargerNodes(root);
        Assertions.assertArrayEquals(new int[] {5, 5, 0}, ints);
    }

    @Test
    void test2() {
        Solution1019.ListNode root = new Solution1019.ListNode(2);
        Solution1019.ListNode next = root;
        next.next = new Solution1019.ListNode(7);
        next = next.next;
        next.next = new Solution1019.ListNode(4);
        next = next.next;
        next.next = new Solution1019.ListNode(3);
        next = next.next;
        next.next = new Solution1019.ListNode(5);
        next = next.next;
        int[] ints = Solution1019.nextLargerNodes(root);
        Assertions.assertArrayEquals(new int[] {7, 0, 5, 5, 0}, ints);
    }

}