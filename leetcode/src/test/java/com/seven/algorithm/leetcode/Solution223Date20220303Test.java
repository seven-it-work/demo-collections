package com.seven.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution223Date20220303;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Solution223Date20220303Test {
    Solution223Date20220303 main;

    @BeforeEach
    void init() {
        main = new Solution223Date20220303();
    }

    @Test
    void case01() {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        int except = 45;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }

    @Test
    void case02() {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2;
        int except = 16;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("全包含")
    void case03() {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -1, by1 = -1, bx2 = 1, by2 = 1;
        int except = 16;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("边重复 包含")
    void case04() {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -1, by1 = -1, bx2 = 2, by2 = 2;
        int except = 16;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }

    @Test
    @DisplayName("边重复 不包含")
    void case05() {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = 2, by1 = 1, bx2 = 3, by2 = 3;
        int except = 18;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }

    @Test
    void error01() {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = 3, by1 = 3, bx2 = 4, by2 = 4;
        int except = 17;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }

    @Test
    void error02() {
        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -1, by1 = -1, bx2 = 1, by2 = 1;
        int except = 16;
        int result = main.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        assertEquals(except, result);
    }
}