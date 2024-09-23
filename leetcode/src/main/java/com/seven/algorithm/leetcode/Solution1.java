/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/two-sum/
 *
 * @author yijialuo
 * @since 2022/9/26 10:51
 */
public class Solution1 {
    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 54.14% 的用户
     * 内存消耗： 42.1 MB , 在所有 Java 提交中击败了 9.78% 的用户
     * 2022/09/26 11:01:42
     */
    public static int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> valueAndIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueAndIndexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            final Integer index = valueAndIndexMap.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }
        return new int[] {};
    }
}
