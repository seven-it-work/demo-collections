/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode.interviewQuestions;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/check-permutation-lcci/
 *
 * @author yijialuo
 * @since 2022/9/27 11:33
 */
public class Interview0102 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 21.48% 的用户
     * 2022/09/27 11:37:34
     */
    public static boolean CheckPermutation(String s1, String s2) {
        final HashMap<Character, Integer> s1Map = new HashMap<>();
        final HashMap<Character, Integer> s2Map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            final Integer orDefault = s1Map.getOrDefault(c, 0);
            s1Map.put(c, orDefault + 1);
        }
        for (char c : s2.toCharArray()) {
            final Integer orDefault = s2Map.getOrDefault(c, 0);
            s2Map.put(c, orDefault + 1);
        }
        return s1Map.equals(s2Map);
    }
}
