/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode.interviewQuestions;

/**
 * https://leetcode.cn/problems/string-rotation-lcci/
 *
 * @author yijialuo
 * @since 2022/9/29 9:07
 */
public class Interview0109 {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.2 MB , 在所有 Java 提交中击败了 91.67% 的用户
     * 2022/09/29 09:17:57
     */
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }
}
