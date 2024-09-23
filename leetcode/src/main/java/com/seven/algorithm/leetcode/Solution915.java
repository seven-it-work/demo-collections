/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

/**
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 *
 * @author yijialuo
 * @since 2022/10/24 9:06
 */
public class Solution915 {
    public static int partitionDisjoint(int[] nums) {
        return partitionDisjoint1(nums);
    }

    /**
     * 时间 2 ms 击败 100%
     * 内存 50.5 MB 击败 77.9%
     * 2022/10/24 09:52:30
     */
    private static int partitionDisjoint1(int[] nums) {
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        int letMax = nums[0];
        for (int i = 0; i < minIndex; i++) {
            if (letMax < nums[i]) {
                letMax = nums[i];
            }
        }
        int resultIndex = minIndex;
        int tempMax = letMax;
        for (int i = minIndex + 1; i < nums.length; i++) {
            if (letMax > nums[i]) {
                resultIndex = i;
                letMax = tempMax;
            } else {
                tempMax = Math.max(tempMax, nums[i]);
            }
        }
        return resultIndex + 1;
    }
}
