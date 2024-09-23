/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 1638. 统计只差一个字符的子串数目 https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/description/
 *
 * @date 2023/3/27 8:40
 */
public class Solution1638 {
    public static int countSubstrings(String s, String t) {
        return countSubstrings1(s, t);
    }

    /**
     * 无脑暴力
     * 时间 163 ms 击败 5.15% 内存 41.5 MB 击败 22.68%
     * 2023-3-27 08:57:06
     */
    private static int countSubstrings1(String s, String t) {
        int count = 0;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String substring = s.substring(i, i + len);
                for (int j = 0; j < t.length() - len + 1; j++) {
                    String tSubStr = t.substring(j, j + len);
                    if (!substring.equals(tSubStr)) {
                        if (matchSize(substring, tSubStr)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private static boolean matchSize(String substring, String tSubStr) {
        char[] chars1 = substring.toCharArray();
        char[] chars2 = tSubStr.toCharArray();
        int notLikeCount = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                notLikeCount++;
            }
            if (notLikeCount > 1) {
                return false;
            }
        }
        return notLikeCount == 1;
    }
}
