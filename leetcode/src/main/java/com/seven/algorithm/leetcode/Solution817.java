/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yijialuo
 * @since 2022/10/12 10:27
 */
public class Solution817 {
    /**
     * 时间9 ms 击败10.54%
     * 内存42.1 MB 击败55.27%
     * 2022/10/12 10:47:23
     */
    public static int numComponents(ListNode head, int[] nums) {
        final Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode next = head;
        ListNode pre = null;
        int count = 0;
        while (next != null) {
            if (!numsSet.contains(next.val)) {
                if (pre != null) {
                    count++;
                }
                pre = null;
            } else {
                pre = next;
            }
            next = next.next;
        }
        if (pre != null) {
            count++;
        }
        return count;
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
