/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

/**
 * https://leetcode.cn/problems/fruit-into-baskets/
 *
 * @author yijialuo
 * @since 2022/10/17 15:09
 */
public class Solution904 {
    public static int totalFruit(int[] fruits) {
        return totalFruit1(fruits);
    }

    /**
     * 2022/10/17 15:42:18
     * 时间 14 ms 击败 64.47%
     * 内存 50.6 MB 击败 44.90%
     */
    private static int totalFruit1(int[] fruits) {
        int maxFruit = 0;
        int tempCount = 0;
        int lastIndex = 0;
        int[] baskets = new int[] {-1, -1};
        for (int i = 0; i < fruits.length; i++) {
            if (baskets[0] == -1) {
                baskets[0] = fruits[i];
                tempCount++;
            } else if (baskets[0] == fruits[i]) {
                tempCount++;
            } else if (baskets[1] == -1) {
                lastIndex = i - 1;
                baskets[1] = fruits[i];
                tempCount++;
            } else if (baskets[1] == fruits[i]) {
                tempCount++;
            } else {
                i = lastIndex;
                baskets[0] = -1;
                baskets[1] = -1;
                maxFruit = Math.max(maxFruit, tempCount);
                tempCount = 0;
            }
        }
        maxFruit = Math.max(maxFruit, tempCount);
        return maxFruit;
    }
}
