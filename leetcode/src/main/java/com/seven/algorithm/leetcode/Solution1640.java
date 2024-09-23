/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/check-array-formation-through-concatenation/
 *
 * @author yijialuo
 * @since 2022/9/22 9:33
 */
public class Solution1640 {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 73.76% 的用户
     * 内存消耗： 40.7 MB , 在所有 Java 提交中击败了 75.53% 的用户
     * 存在缺陷：
     * <p>
     * 1. 未考虑arr 和pieces中，如果有相同的，但是一方数量少的情况
     * eg：{1,2,3,1,2,3} {{1,2,3}} 期望false
     * </P>
     */
    public static boolean canFormArrayMyAC(int[] arr, int[][] pieces) {
        if (arr == null || pieces == null) {
            return arr == null & pieces == null;
        }
        final String arrStr = arr2Str(arr);
        for (int[] piece : pieces) {
            final String temp = arr2Str(piece);
            if (arrStr.contains(temp)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private static String arr2Str(int[] arr) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i : arr) {
            stringBuilder.append(i).append(",");
        }
        return stringBuilder.toString();
    }

    /**
     * 存在缺陷：
     * <p>
     * 2. 如果两个数字中有重复的，也同样有问题
     * eg：{12} {{1}} 期望false
     * </P>
     */
    private static String arr2StrBad(int[] arr) {
        return Arrays.stream(arr)
            .boxed()
            .map(Object::toString)
            .collect(Collectors.joining(","));
    }
}
