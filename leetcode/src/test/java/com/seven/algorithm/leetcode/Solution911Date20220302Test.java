package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution911Date20220302;

class Solution911Date20220302Test {
    @BeforeEach
    void init() {
    }

    @Test
    void case01() {
        int[] persons = new int[]{0, 1, 1, 0, 0, 1, 0};
        int[] times = new int[]{0, 5, 10, 15, 20, 25, 30};
        int[] q = {3, 12, 25, 15, 24, 8};
        int[] except = new int[]{0, 1, 1, 0, 0, 1};
        Solution911Date20220302.TopVotedCandidate topVotedCandidate = new Solution911Date20220302.TopVotedCandidate(persons, times);
        int[] result = runCore(q, topVotedCandidate);
        assertArrayEquals(except, result);
    }

    @Test
    void case02() {
        int[] persons = new int[]{0, 0, 1, 1, 2};
        int[] times = new int[]{0, 67, 69, 74, 87};
        int[] q = {4, 62, 100, 88, 70, 73, 22, 75, 29, 10};
        int[] except = new int[]{0, 0, 1, 1, 0, 0, 0, 1, 0, 0};
        Solution911Date20220302.TopVotedCandidate topVotedCandidate = new Solution911Date20220302.TopVotedCandidate(persons, times);
        int[] result = runCore(q, topVotedCandidate);
        assertArrayEquals(except, result);
    }

    private int[] runCore(int[] q, Solution911Date20220302.TopVotedCandidate topVotedCandidate) {
        int[] result = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            result[i] = topVotedCandidate.q(q[i]);
        }
        return result;
    }
}