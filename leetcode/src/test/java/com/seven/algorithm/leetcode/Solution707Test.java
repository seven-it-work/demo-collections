package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution707Test {
    @Test
    void test1() {
        Solution707.MyLinkedList linkedList = new Solution707.MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        Assertions.assertEquals("1->2->3", linkedList.toStr());   //链表变为1-> 2-> 3
        Assertions.assertEquals(2, linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);
        Assertions.assertEquals("1->3", linkedList.toStr());//现在链表是1-> 3
        Assertions.assertEquals(3, linkedList.get(1));            //返回3
    }
}