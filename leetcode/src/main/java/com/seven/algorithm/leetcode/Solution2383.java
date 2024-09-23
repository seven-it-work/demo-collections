/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;

/**
 * 2383. 赢得比赛需要的最少训练时长 <a href="https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/description/">...</a>
 *
 * @date 2023/3/13 9:10
 */
public class Solution2383 {
    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        return minNumberOfHours1(initialEnergy, initialExperience, energy, experience);
    }

    /**
     * 2023-3-13 09:46:02
     * 间 2 ms 击败 17.37% 内存 41 MB 击败 41.32%
     * <P>精力 大于energy的和</P>
     * <P>经验 正序和 大于最大值</P>
     *
     * @param initialEnergy
     * @param initialExperience
     * @param energy
     * @param experience
     * @return
     */
    private static int minNumberOfHours1(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        // 最大精力
        long maxEnergy = Arrays.stream(energy).sum() + 1;
        // 最小开始经验
        int minExperience = 0;
        int tempSumExperience = minExperience;
        // 继续所需经验
        for (int j : experience) {
            if (tempSumExperience < j) {
                minExperience = Math.max(j - tempSumExperience + 1, minExperience);
            }
            tempSumExperience += j;
        }
        int hours = 0;
        if (maxEnergy > initialEnergy) {
            hours += maxEnergy - initialEnergy;
        }
        if (minExperience > initialExperience) {
            hours += minExperience - initialExperience;
        }
        return hours;
    }
}
