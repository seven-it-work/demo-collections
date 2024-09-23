package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution287Date20220223;

class Solution287Date20220223Test {
    Solution287Date20220223 main;

    @BeforeEach
    void init() {
        main = new Solution287Date20220223();
    }

    @Test
    void case01() {
        int[] ints = new int[]{1, 3, 4, 2, 2};
        int result = main.findDuplicate(ints);
        int except = 2;
        assertEquals(result, except);
    }

    @Test
    void case02() {
        int[] ints = new int[]{3, 1, 3, 4, 2};
        int result = main.findDuplicate(ints);
        int except = 3;
        assertEquals(result, except);
    }

    @Test
    void case03() {
        int[] ints = new int[]{3, 1, 4, 4, 2};
        int result = main.findDuplicate(ints);
        int except = 4;
        assertEquals(result, except);
    }

}