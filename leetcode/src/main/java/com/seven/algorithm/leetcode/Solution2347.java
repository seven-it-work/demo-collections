/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.HashMap;

/**
 * 2347. 最好的扑克手牌 https://leetcode.cn/problems/best-poker-hand/
 *
 * @date 2023/2/20 8:56
 */
public class Solution2347 {
    public static String bestHand(int[] ranks, char[] suits) {
        return bestHand1(ranks, suits);
    }

    /**
     * 2023-2-20 09:05:37
     * 时间 1 ms 击败 31.63% 内存 39.2 MB 击败 44.90%
     *
     * @param ranks
     * @param suits
     * @return
     */
    private static String bestHand1(int[] ranks, char[] suits) {
        boolean isFlush = true;
        for (int i = 1; i < suits.length; i++) {
            if (suits[0] != suits[i]) {
                isFlush = false;
                break;
            }
        }
        if (isFlush) {
            return "Flush";
        }
        HashMap<Integer, Integer> valueAndSize = new HashMap<>();
        for (int rank : ranks) {
            valueAndSize.put(rank, valueAndSize.getOrDefault(rank, 0) + 1);
        }
        boolean isPair = false;
        for (Integer value : valueAndSize.values()) {
            if (value >= 3) {
                return "Three of a Kind";
            }
            if (value >= 2) {
                isPair = true;
            }
        }
        if (isPair) {
            return "Pair";
        }
        return "High Card";
    }
}
