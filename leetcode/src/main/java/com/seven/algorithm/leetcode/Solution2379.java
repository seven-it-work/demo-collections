/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 2379. 得到 K 个黑块的最少涂色次数 https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
 *
 * @date 2023/3/9 9:10
 */
public class Solution2379 {
    public static int minimumRecolors(String blocks, int k) {
        return minimumRecolors1(blocks, k);
    }

    /**
     * 滑动窗口
     * 时间 0 ms 击败 100% 内存 39.6 MB 击败 51.18%
     * 2023-3-9 09:33:14
     */
    private static int minimumRecolors1(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        // 统计开始的数量
        int countW = 0;
        for (int i = 0; i < k; i++) {
            if (chars[i] == 'W') {
                countW++;
            }
        }
        int result = countW;
        for (int i = 1; i <= chars.length - k; i++) {
            // 上一个字符
            if (chars[i - 1] == 'W') {
                countW--;
            }
            // 下一个字符
            if (chars[i + k - 1] == 'W') {
                countW++;
            }
            result = Math.min(countW, result);
        }
        return result;
    }
}
