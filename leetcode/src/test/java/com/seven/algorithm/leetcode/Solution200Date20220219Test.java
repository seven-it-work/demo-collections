package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution200Date20220219;

class Solution200Date20220219Test {
    Solution200Date20220219 main;

    @BeforeEach
    void init() {
        main = new Solution200Date20220219();
    }

    @Test
    void case01() {
        char[][] grids = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result = main.numIslands(grids);
        int except = 1;
        assertEquals(result, except);
    }

    @Test
    void case02() {
        char[][] grids = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = main.numIslands(grids);
        int except = 3;
        assertEquals(result, except);
    }

    @Test
    void case03() {
        char[][] grids = {
                {'1', '1', '1', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result = main.numIslands(grids);
        int except = 4;
        assertEquals(result, except);
    }
}