package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.seven.algorithm.leetcode.Solution1797Date20220227;

class Solution1797Date20220227Test {


    @Test
    void case01() {
        String[] strings = new String[]{"AuthenticationManager", "renew", "generate", "countUnexpiredTokens", "generate", "renew", "renew", "countUnexpiredTokens"};
        Object[][] ints = new Object[][]{{5}, {"aaa", 1}, {"aaa", 2}, {6}, {"bbb", 7}, {"aaa", 8}, {"bbb", 10}, {15}};
        Integer[] except = new Integer[]{null, null, null, 1, null, null, null, 0};
        Integer[] result = runCore(strings, ints);
        assertArrayEquals(except, result);
    }

    private Integer[] runCore(String[] strings, Object[][] params) {
        Integer[] result = new Integer[strings.length];
        if ("AuthenticationManager".equals(strings[0])) {
            Solution1797Date20220227.AuthenticationManager authenticationManager = new Solution1797Date20220227.AuthenticationManager((int) params[0][0]);
            for (int i = 1; i < strings.length; i++) {
                switch (strings[i]) {
                    case "renew":
                        authenticationManager.renew((String) params[i][0], (int) params[i][1]);
                        break;
                    case "generate":
                        authenticationManager.generate((String) params[i][0], (int) params[i][1]);
                        break;
                    case "countUnexpiredTokens":
                        result[i] = authenticationManager.countUnexpiredTokens((int) params[i][0]);
                        break;
                    default:
                }
            }
        }
        return result;
    }
}