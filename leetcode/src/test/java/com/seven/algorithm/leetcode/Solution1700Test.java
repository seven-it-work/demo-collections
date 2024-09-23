package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution1700Test {
    @Test
    void test1() {
        int[] students = {1, 1, 1, 0, 0, 1}, sandwiches = {1, 0, 0, 0, 1, 1};
        Assertions.assertEquals(3, Solution1700.countStudents(students, sandwiches));
    }
    @Test
    void test2() {
        int[] students = {1, 1, 1,1}, sandwiches = {1,1,1,0};
        Assertions.assertEquals(1, Solution1700.countStudents(students, sandwiches));
    }
    @Test
    void test3() {
        int[] students = {1,1,0,0}, sandwiches = {0,1,0,1};
        Assertions.assertEquals(0, Solution1700.countStudents(students, sandwiches));
    }
}