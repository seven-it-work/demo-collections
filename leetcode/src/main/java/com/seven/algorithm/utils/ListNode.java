/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.utils;

import lombok.ToString;

@ToString
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
