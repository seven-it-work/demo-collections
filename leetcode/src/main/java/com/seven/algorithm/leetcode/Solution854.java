/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

/**
 * https://leetcode.cn/problems/k-similar-strings/
 *
 * @author yijialuo
 * @since 2022/9/21 17:27
 */
public class Solution854 {
    /**
     * 基本思路：
     * 不断遍历字符，如果s1和s2同一index的char不同，则找s2中最近的char(来着s1)进行交互，然后递归
     * 不适用场景：ababab bababa 就会交换3次。。。
     */
    public static int kSimilarityMyNoPass(String s1, String s2) {
        return kSimilarityDo(s1, s2, 0, 0);
    }

    private static int kSimilarityDo(String s1, String s2, int start, int changeCount) {
        for (int i = start; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else {
                final int end = s2.indexOf(s1.charAt(i), i);
                final String newS2 = change(s2, i, end);
                changeCount++;
                return kSimilarityDo(s1, newS2, i + 1, changeCount);
            }
        }
        return changeCount;
    }

    private static String change(String s2, int start, int end) {
        final char[] chars = s2.toCharArray();
        final char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        return new String(chars);
    }
}
