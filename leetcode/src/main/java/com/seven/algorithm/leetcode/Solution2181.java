package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.ListNode;
import com.seven.algorithm.utils.TransformUtils;


/**
 * 2181. 合并零之间的节点
 * https://leetcode.cn/problems/merge-nodes-in-between-zeros/description/?envType=daily-question&envId=2024-09-09
 * 2024-9-9 09:45:56
 */
public class Solution2181 {
    public static void main(String[] args) {
        System.out.println(new Solution2181().mergeNodes(TransformUtils.arrays2ListNode("[0,3,1,0,4,5,2,0]")));
    }

    /**
     * 2024-9-9 09:57:29
     * 遍历，如果是0创建个新的listNode，将是否创建bool改为true
     * 求和，求和
     * 遍历，如果是0且创建bool为true，将求和值作为node给到listNode中，指向移动到next，并创建新的listNode
     * 2024-9-9 10:11:19
     *
     * @param head
     * @return
     */
    public ListNode mergeNodes(ListNode head) {
        int tempSum = 0;
        ListNode result = new ListNode();
        // 结果listNode的指向游标
        ListNode resultNext = result;
        // 遍历的指向游标
        ListNode next = head;
        while (next != null) {
            if (next.val == 0) {
                if (resultNext.next == null) {
                    resultNext.next = new ListNode();
                } else {
                    resultNext.next.val = tempSum;
                    resultNext = resultNext.next;
                    resultNext.next = new ListNode();
                    tempSum = 0;
                }
            } else {
                tempSum += next.val;
            }
            next = next.next;
        }
        // 移除最后的0
        resultNext.next = null;
        return result.next;
    }

}
