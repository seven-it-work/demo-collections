package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution2Test {
    @Test
    void test1() {
        final Solution2.ListNode l1 = new Solution2.ListNode(2, new Solution2.ListNode(4, new Solution2.ListNode(3)));
        final Solution2.ListNode l2 = new Solution2.ListNode(5, new Solution2.ListNode(6, new Solution2.ListNode(4)));
        final Solution2.ListNode re = new Solution2.ListNode(7, new Solution2.ListNode(0, new Solution2.ListNode(8)));
        Assertions.assertEquals(re.toString(), Solution2.addTwoNumbers(l1, l2).toString());
    }

    @Test
    void test2() {
        final Solution2.ListNode l1 = new Solution2.ListNode(2, new Solution2.ListNode(4, new Solution2.ListNode(9)));
        final Solution2.ListNode l2 = new Solution2.ListNode(5,
            new Solution2.ListNode(6, new Solution2.ListNode(4, new Solution2.ListNode(9))));
        final Solution2.ListNode re = new Solution2.ListNode(7,
            new Solution2.ListNode(0, new Solution2.ListNode(4, new Solution2.ListNode(0, new Solution2.ListNode(1)))));
        Assertions.assertEquals(re.toString(), Solution2.addTwoNumbers(l1, l2).toString());
    }
}