package com.seven.algorithm;

import com.seven.algorithm.leetcode.Solution1238;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution1238Test {
    @Test
    void test1() {
        Assertions.assertEquals(Arrays.asList(3, 2, 0, 1), Solution1238.circularPermutation(2, 3));
    }

    @Test
    void test2() {
        Assertions.assertEquals(Arrays.asList(2, 6, 7, 5, 4, 0, 1, 3), Solution1238.circularPermutation(3, 2));
    }

}