/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/design-linked-list/
 *
 * @author yijialuo
 * @since 2022/9/23 11:09
 */
public class Solution707 {

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 85.25% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 5.00% 的用户
     * 2022/09/23 11:27:53
     */
    public static class MyLinkedList {
        final LinkedList<Integer> list = new LinkedList<>();

        public MyLinkedList() {
        }

        /**
         * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
         */
        public int get(int index) {
            if (!checkIndexLegality(index)) {
                return -1;
            }
            return list.get(index);
        }

        public void addAtHead(int val) {
            list.addFirst(val);
        }

        public void addAtTail(int val) {
            list.addLast(val);
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。
         * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         */
        public void addAtIndex(int index, int val) {
            if (index < 0) {
                this.addAtHead(val);
            } else if (index == list.size()) {
                this.addAtTail(val);
            } else if (index > list.size()) {
                // do nothing
            } else {
                list.add(index, val);
            }
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点。
         */
        public void deleteAtIndex(int index) {
            if (!checkIndexLegality(index)) {
                return;
            }
            list.remove(index);
        }

        public String toStr() {
            final StringBuilder stringBuilder = new StringBuilder();
            list.forEach(integer -> {
                stringBuilder.append(integer).append("->");
            });
            return stringBuilder.substring(0, stringBuilder.length() - 2);
        }

        private boolean checkIndexLegality(int index) {
            if (index < 0) {
                return false;
            }
            return index < list.size();
        }
    }
}
