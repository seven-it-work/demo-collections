package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1669 {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        return mergeInBetween2(list1, a, b, list2);
    }

    /**
     * 2023-1-30 09:43:12
     * 时间 1 ms 击败 100% 内存 44.6 MB 击败 88.27%
     * 2023-1-30 10:10:14
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    private static ListNode mergeInBetween1(ListNode list1, int a, int b, ListNode list2) {
        int splitEnd = b - a;
        ListNode root = new ListNode();
        ListNode next = root;
        ListNode nextList1 = list1;
        while (a > 0) {
            next.next = nextList1;
            nextList1 = nextList1.next;
            next = next.next;
            a--;
        }
        ListNode tempList1EndNext = next.next;
        next.next = list2;
        // 移动到最末尾
        while (next.next != null) {
            next = next.next;
        }
        while (splitEnd >= 0) {
            tempList1EndNext = tempList1EndNext.next;
            splitEnd--;
        }
        next.next = tempList1EndNext;
        return root.next;
    }

    /**
     * 2023-1-30 10:12:11
     * 时间 20 ms 击败 0.64% 内存 48.8 MB 击败 5.12%
     * 2023-1-30 10:21:19
     * <p>
     * 先转list，再合并
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    private static ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
        List<Integer> arrayList1 = convertListNode(list1);
        List<Integer> arrayList2 = convertListNode(list2);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            Integer temp = arrayList1.get(i);
            if (i < a) {
                result.add(temp);
            } else if (i < b) {
            } else if (i == b) {
                result.addAll(arrayList2);
            } else {
                result.add(temp);
            }
        }
        return convertList(result);
    }

    private static List<Integer> convertListNode(ListNode listNode) {
        ListNode next = listNode;
        ArrayList<Integer> result = new ArrayList<>();
        while (next != null) {
            result.add(next.val);
            next = next.next;
        }
        return result;
    }

    private static ListNode convertList(List<Integer> ints) {
        ListNode root = new ListNode();
        ListNode next = root;
        for (int anInt : ints) {
            next.next = new ListNode(anInt);
            next = next.next;
        }
        return root.next;
    }

    static class ListNode {
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
