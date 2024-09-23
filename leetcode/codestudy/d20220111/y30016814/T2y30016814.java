/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220111.y30016814;

import com.huawei.codestudy.d20220111.T2;

/**
 * @author y30016814
 * @since 2022/1/22 9:58
 */
public class T2y30016814 extends T2 {
    @Override
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 第一次选择时
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < nums.length - 1; i++) {
            // dp[i] = Math.max(dp[i - 2])
        }
        return 0;
    }

}
