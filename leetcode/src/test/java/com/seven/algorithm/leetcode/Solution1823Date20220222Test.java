package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution1823Date20220222;

class Solution1823Date20220222Test {
    Solution1823Date20220222 main;

    @BeforeEach
    void init() {
        main = new Solution1823Date20220222();
    }

    @Test
    void case01() {
        int theWinner = main.findTheWinner(5, 2);
        int expected = 3;
        assertEquals(theWinner, expected);
    }

    @Test
    void case02() {
        int theWinner = main.findTheWinner(1, 2);
        int expected = 1;
        assertEquals(theWinner, expected);
    }

    @Test
    void case03() {
        int theWinner = main.findTheWinner(2, 2);
        int expected = 1;
        assertEquals(theWinner, expected);
    }

    @Test
    void case04() {
        int theWinner = main.findTheWinner(5, 3);
        int expected = 4;
        assertEquals(theWinner, expected);
    }
    @Test
    void case05() {
        int theWinner = main.findTheWinner(6, 5);
        int expected = 1;
        assertEquals(theWinner, expected);
    }
}