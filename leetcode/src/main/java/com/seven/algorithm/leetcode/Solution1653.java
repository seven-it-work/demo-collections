/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 1653. 使字符串平衡的最少删除次数 https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 *
 * @date 2023/3/6 9:07
 */
public class Solution1653 {
    public static int minimumDeletions(String s) {
        return minimumDeletionsSolution1(s);
    }

    /**
     * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/discussion/comments/1944348
     * 时间 42 ms 击败 31.87% 内存 42.3 MB 击败 46.70%
     * 2023-3-6 10:06:27
     */
    private static int minimumDeletionsSolution1(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'a') {
                cnt++;
            }
        }
        int ans = cnt;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'a') {
                cnt--;
            } else {
                cnt++;
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }

    /**
     * 场景遗漏
     */
    private static int minimumDeletions1(String s) {
        // b后面a的个数
        // a前面b的个数
        char[] chars = s.toCharArray();
        int bBefore = 0;
        boolean bBeforeStart = false;
        int aAfter = 0;
        int aAfterEndIndex = s.lastIndexOf("a");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b') {
                bBeforeStart = true;
            }
            if (bBeforeStart && chars[i] == 'a') {
                bBefore++;
            }
            if (i <= aAfterEndIndex && chars[i] == 'b') {
                aAfter++;
            }
        }
        return Math.min(bBefore, aAfter);
    }
}
