/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author yijialuo
 * @since 2022/10/10 15:46
 */
public class Solution801NO {
    public static int minSwap(int[] nums1, int[] nums2) {
        return minSwap1(nums1, nums2);
    }

    /**
     * 参考：https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/solution/zhua-wa-mou-si-tu-jie-leetcode-by-muse-7-kmio/
     * <P>上一次dp[i-1][0] 不交换时的次数累计</P>
     * <P>上一次dp[i-1][1] 交换时的次数累计</P>
     * <P>当前  dp[i][0] 不交换时的次数累计</P>
     * <P>当前  dp[i][1] 交换时的次数累计</P>
     * <P>如果初始递增，交换也是递增：交不交换都行。不交换dp[i][0]取上一次交换/不交换的最小值。交换dp[i][1]取上一次交换的值+1</P>
     * <P>如果初始递增，交换不是递增：当前交换，上一次就要交换（反之不交换，上一次不交换）。不交换dp[i][0]取上一次不交换的值。交换dp[i][1]取上一次交换的值+1</P>
     * <P>如果初始不是递增，交换是递增：当前交换，上一次不交换（反之不交换，上一次就交换）。不交换dp[i][0]取上一次交换的值。交换dp[i][1]取上一次不交换的值+1</P>
     * <P>难点：
     * 1、对dp的构造，怎么能想的到[0]是不交换[1]是交换？只能多刷动态规划的题，来进行总结经验
     * 2、对条件的梳理，怎么能想得到3个如果？
     * </P>
     */
    private static int minSwap1(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][2];
        for (int i = 1; i < nums1.length; i++) {
            int num10 = nums1[i - 1];
            int num11 = nums1[i];
            int num20 = nums2[i - 1];
            int num21 = nums2[i];
            if ((num10 < num11 && num20 < num21) &&
                (num10 < num21 && num20 < num11)) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][1] + 1;
            } else if (num10 < num11 && num20 < num21) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
            printDp(dp);
        }
        return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
    }

    private static void printDp(int[][] dp) {
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("------------------------------------");
    }
}
