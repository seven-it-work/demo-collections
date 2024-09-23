/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

/**
 * https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 *
 * @author yijialuo
 * @since 2022/10/18 15:44
 */
public class Solution902 {
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        return atMostNGivenDigitSet1(digits, n);
    }

    /**
     * 2022/10/18 17:49:50
     * 时间 0 ms 击败 100%
     * 内存 38.7 MB 击败 81.3%
     */
    private static int atMostNGivenDigitSet1(String[] digits, int n) {
        char[] target = String.valueOf(n).toCharArray();
        char[] digitsChar = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digitsChar[i] = (char) (Integer.parseInt(digits[i]) + '0');
        }
        int len = target.length, choice = digitsChar.length;
        // 位数小于len的
        int result1 = 0;
        for (int i = 1, tmp = 1; i < len; i++) {
            tmp *= choice;
            result1 += tmp;
        }
        // 位数相同
        int result2 = 0;
        for (int i = 0; i < len; i++) {
            int j = 0;
            for (; j < choice; j++) {
                if (digitsChar[j] >= target[i]) {
                    break;
                }
            }
            result2 += j * Math.pow(choice, len - i - 1);
            if (j == choice || digitsChar[j] != target[i]) {
                break;
            }
            if (digitsChar[j] == target[i] && i == len - 1) {
                result2 += 1;
            }
        }
        return result1 + result2;
    }
}
