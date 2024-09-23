/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/defuse-the-bomb/
 *
 * @author yijialuo
 * @since 2022/9/24 11:28
 */
public class Solution1652 {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 84.29% 的用户
     * 2022/09/24 11:49:25
     */
    public static int[] decrypt(int[] code, int k) {
        final int[] ints = new int[code.length];
        if (k == 0) {
            Arrays.fill(ints, 0);
        } else {
            for (int i = 0; i < code.length; i++) {
                int result = calculation(code, k, i);
                ints[i] = result;
            }
        }
        return ints;
    }

    private static int calculation(int[] code, int k, int i) {
        int result = 0;
        while (true) {
            if (k < 0) {
                result += code[(i + k + code.length) % code.length];
                k++;
            } else if (k > 0) {
                result += code[(i + k + code.length) % code.length];
                k--;
            } else {
                return result;
            }
        }
    }
}
