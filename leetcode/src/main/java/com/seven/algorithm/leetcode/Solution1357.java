/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;

/**
 * 2357. 使数组中所有元素都等于零 <a href="https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/">...</a>
 *
 * @date 2023/2/24 9:05
 */
public class Solution1357 {
    public static int minimumOperations(int[] nums) {
        return minimumOperations1(nums);
    }

    /**
     * 2023-2-24 09:48:11
     * 时间 1 ms 击败 57.44% 内存 38.9 MB 击败 93.59%
     * @param nums
     * @return
     */
    private static int minimumOperations1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                minIndex = i;
                break;
            }
        }
        return mini(nums, minIndex, count);
    }

    private static int mini(int[] nums, int minIndex, int count) {
        if (nums[nums.length - 1] <= 0) {
            return count;
        }
        int tempNum = nums[minIndex];
        for (int i = minIndex; i < nums.length; i++) {
            nums[i] = nums[i] - tempNum;
        }
        while (nums[minIndex] <= 0 && minIndex < nums.length - 1) {
            minIndex++;
        }
        count++;
        return mini(nums, minIndex, count);
    }
}
