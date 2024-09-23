package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Solution1669Test {
    @Test
    void test1() {
        int[] list1 = {0, 1, 2, 3, 4, 5};
        int[] list2 = {1000000, 1000001, 1000002};
        Solution1669.ListNode result = Solution1669.mergeInBetween(convertList(list1), 3, 4, convertList(list2));
        int[] except = {0, 1, 2, 1000000, 1000001, 1000002, 5};
        Assertions.assertArrayEquals(except, convertListNode(result));
    }

    @Test
    void test2() {
        int[] list1 = {0, 1, 2, 3, 4, 5, 6};
        int[] list2 = {1000000, 1000001, 1000002, 1000003, 1000004};
        Solution1669.ListNode result = Solution1669.mergeInBetween(convertList(list1), 2, 5, convertList(list2));
        int[] except = {0, 1, 1000000, 1000001, 1000002, 1000003, 1000004, 6};
        Assertions.assertArrayEquals(except, convertListNode(result));
    }
    @Test
    void test3() {
        int[] list1 = {0, 1, 2, 3, 4, 5, 6};
        int[] list2 = {1000000};
        Solution1669.ListNode result = Solution1669.mergeInBetween(convertList(list1), 2, 5, convertList(list2));
        int[] except = {0, 1, 1000000, 6};
        Assertions.assertArrayEquals(except, convertListNode(result));
    }

    private int[] convertListNode(Solution1669.ListNode listNode) {
        Solution1669.ListNode next = listNode;
        ArrayList<Integer> result = new ArrayList<>();
        while (next != null) {
            result.add(next.val);
            next = next.next;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private Solution1669.ListNode convertList(int[] ints) {
        Solution1669.ListNode root = new Solution1669.ListNode();
        Solution1669.ListNode next = root;
        for (int anInt : ints) {
            next.next = new Solution1669.ListNode(anInt);
            next = next.next;

        }
        return root.next;
    }

}