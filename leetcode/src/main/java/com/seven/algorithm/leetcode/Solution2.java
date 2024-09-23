/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

/**
 * https://leetcode.cn/problems/add-two-numbers/
 *
 * @author yijialuo
 * @since 2022/9/26 11:10
 */
public class Solution2 {
    /**
     * 执行用时： 14 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.9 MB , 在所有 Java 提交中击败了 7.25% 的用户
     * 2022/09/26 11:33:28
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return bigDecimal2ListNode(listNode2BigDecimal(l1).add(listNode2BigDecimal(l2)));
    }

    private static ListNode bigDecimal2ListNode(java.math.BigDecimal bigDecimal) {
        final String string = bigDecimal.toBigInteger().toString();
        final ListNode root = new ListNode();
        ListNode next = root;
        final String[] split = string.split("");
        for (int i = split.length - 1; i >= 0; i--) {
            final String s = split[i];
            next.next = new ListNode(Integer.parseInt(s));
            next = next.next;
        }
        return root.next;
    }

    private static java.math.BigDecimal listNode2BigDecimal(ListNode listNode) {
        final StringBuilder stringBuilder = new StringBuilder();
        ListNode next = listNode;
        while (next != null) {
            stringBuilder.append(next.val);
            next = next.next;
        }
        return new java.math.BigDecimal(stringBuilder.reverse().toString());
    }

    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
