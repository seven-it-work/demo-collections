/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220111.h30022790;

import com.huawei.codestudy.d20220111.T2;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-14
 */
public class T2Rob extends T2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new T2Rob().rob(nums));
    }

    /**
     * 2 3 2
     * dp[i][j]: 从第i间偷到第j间时最大金额
     *
     * k = n - 1:
     * dp[0][k] = max{dp[1][k-2] + dp[k][k], dp[0][k-1]} : 第1间偷到第k-2间 + 第k间，第0间偷到第k-1间
     * k < n - 1:
     * dp[0][k] = max{dp[0][k-2] + dp[k][k], dp[0][k-1]}
     *
     * dp[1][k] = max{dp[1][k-2] + dp[k][k], dp[1][k-1]}
     * dp[k][k] = nums[k]
     *
     * dp[1][2] = max{dp[1][1], dp[2][2]}
     *
     * 第k次偷nums[k]
     *
     *
     * @param nums 可偷取金额
     * @return
     */
    @Override
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[][] dp = new int[2][n];
        dp[0][0] = nums[0];
        dp[0][1] = Math.max(nums[0], nums[1]);
        dp[1][1] = nums[1];
        dp[1][2] = Math.max(nums[1], nums[2]);
        dp[0][2] = n > 3 ? Math.max(Math.max(dp[0][1], dp[1][2]), nums[0] + nums[2]) : Math.max(dp[0][1], dp[1][2]);
        for (int k = 3; k < n; k++) {
            dp[1][k] = Math.max(dp[1][k-2] + nums[k], dp[1][k-1]);
            if (k < n - 1) {
                dp[0][k] = Math.max(dp[0][k-2] + nums[k], dp[0][k-1]);
            }
        }
        dp[0][n-1] = Math.max(dp[1][n-3] + nums[n-1], dp[0][n-2]);
        return dp[0][n-1];
    }
}
