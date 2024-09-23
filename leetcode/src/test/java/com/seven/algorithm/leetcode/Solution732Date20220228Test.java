package com.seven.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution732Date20220228;

import org.junit.jupiter.api.Test;

class Solution732Date20220228Test {

    @Test
    void case01() {
        int[][] ints = new int[][] {{10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
        int[] except = new int[] {1, 1, 2, 3, 3, 3};
        int[] actual = runCore(ints);
        assertArrayEquals(except, actual);
    }

    /**
     * 就一个线段
     */
    @Test
    void case02() {
        int[][] ints = new int[][] {{1, 2}};
        int[] except = new int[] {1};
        int[] actual = runCore(ints);
        assertArrayEquals(except, actual);
    }

    /**
     * 没有重复
     */
    @Test
    void case03() {
        int[][] ints = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[] except = new int[] {1, 1, 1, 1};
        int[] actual = runCore(ints);
        assertArrayEquals(except, actual);
    }

    /**
     * 有重复2，后面有个更大的重复3
     */
    @Test
    void case04() {
        int[][] ints = new int[][] {{1, 3}, {2, 3}, {3, 6}, {4, 6}, {5, 6}};
        int[] except = new int[] {1, 2, 2, 2, 3};
        int[] actual = runCore(ints);
        assertArrayEquals(except, actual);
    }

    private int[] runCore(int[][] ints) {
        Solution732Date20220228.MyCalendarThree myCalendarThree = new Solution732Date20220228.MyCalendarThree();
        int[] result = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = myCalendarThree.book(ints[i][0], ints[i][1]);
        }
        return result;
    }

}