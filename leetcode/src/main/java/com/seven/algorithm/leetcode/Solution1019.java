/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点 https://leetcode.cn/problems/next-greater-node-in-linked-list/
 *
 * @date 2023/4/10 8:52
 */
public class Solution1019 {

    public static int[] nextLargerNodes(ListNode head) {
        return nextLargerNodes1(head);
    }

    /**
     * 时间 48 ms 击败 43.74% 内存 48.1 MB 击败 5.14%
     * 2023-4-10 09:17:553
     *
     * @param head
     * @return
     */
    private static int[] nextLargerNodes1(ListNode head) {
        HashMap<Integer, TempNode> result = new HashMap<>();
        Stack<TempNode> tempNodes = new Stack<>();
        ListNode next = head;
        int index = 0;
        while (next != null) {
            TempNode tempNode = new TempNode(index, next.val);
            checkAndSet(result, tempNodes, tempNode);
            tempNodes.add(tempNode);
            next = next.next;
            index++;
        }
        while (!tempNodes.isEmpty()) {
            TempNode pop = tempNodes.pop();
            result.put(pop.index, pop);
            index++;
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = result.get(i).result;
        }
        return ints;
    }

    private static void checkAndSet(HashMap<Integer, TempNode> result, Stack<TempNode> tempNodes,
        TempNode tempNode) {
        if (!tempNodes.isEmpty()) {
            TempNode peek = tempNodes.peek();
            if (tempNode.value > peek.value) {
                TempNode pop = tempNodes.pop();
                pop.result = tempNode.value;
                result.put(pop.index, pop);
                checkAndSet(result, tempNodes, tempNode);
            }
        }
    }

    private static class TempNode {
        private int index;

        private int value;

        private int result = 0;

        public TempNode(int index, int value) {
            this.index = index;
            this.value = value;
        }
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
    }
}

