package com.seven.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution593Date20220303;

import org.junit.jupiter.api.Test;

class Solution593Date20220303Test {

    @Test
    void case01() {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 1};
        assertTrue(new Solution593Date20220303().validSquare(p1, p2, p3, p4));
    }

    @Test
    void case02() {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {0, 12};
        assertFalse(new Solution593Date20220303().validSquare(p1, p2, p3, p4));
    }

    @Test
    void case03() {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {1, 0};
        assertFalse(new Solution593Date20220303().validSquare(p1, p2, p3, p4));
    }

    @Test
    void case04() {
        int[] p1 = {1, 0}, p2 = {-1, 0}, p3 = {0, 1}, p4 = {0, -1};
        assertTrue(new Solution593Date20220303().validSquare(p1, p2, p3, p4));
    }

    @Test
    void case05() {
        int[] p1 = {0, 0}, p2 = {-1, 0}, p3 = {1, 0}, p4 = {0, 1};
        assertFalse(new Solution593Date20220303().validSquare(p1, p2, p3, p4));
    }

    @Test
    void case06() {
        int[] p1 = {0, 0}, p2 = {1, 1}, p3 = {1, 0}, p4 = {1, 0};
        assertFalse(new Solution593Date20220303().validSquare(p1, p2, p3, p4));
    }
}