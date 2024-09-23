/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220111.y30016814;

import com.huawei.codestudy.d20220111.T3;

/**
 * @author y30016814
 * @since 2022/1/22 10:18
 */
public class T3y30016814 extends T3 {
    @Override
    public int smallestDistancePair(int[] nums, int k) {
        return this.smallestDistancePairViolence(nums, k);
    }

    /**
     * 暴力求解
     */
    public int smallestDistancePairViolence(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[(i + k) % nums.length];
            min = Math.min(min, Math.abs(num - nums[i]));
        }
        return min;
    }
}
