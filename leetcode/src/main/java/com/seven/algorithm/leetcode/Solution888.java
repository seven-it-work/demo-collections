/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 888. 公平的糖果交换 https://leetcode.cn/problems/fair-candy-swap/
 *
 * @date 2023/4/6 8:56
 */
public class Solution888 {
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        return fairCandySwap2(aliceSizes, bobSizes);
    }

    /**
     * 时间 18 ms 击败 37.97% 内存 43.3 MB 击败 39.66%
     * 2023-4-6 09:52:29
     */
    private static int[] fairCandySwap2(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = Arrays.stream(aliceSizes).sum();
        int bobSum = Arrays.stream(bobSizes).sum();
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);
        int moreCandy = (aliceSum - bobSum) / 2;
        // 双指针
        int aliceIndex = 0;
        int bobIndex = 0;
        while (aliceIndex < aliceSizes.length && bobIndex < bobSizes.length) {
            int more = aliceSizes[aliceIndex] - bobSizes[bobIndex];
            if (more == moreCandy) {
                return new int[] {aliceSizes[aliceIndex], bobSizes[bobIndex]};
            } else if (more > moreCandy) {
                bobIndex++;
            } else {
                aliceIndex++;
            }
        }
        return new int[2];
    }

    /**
     * 超时
     * 2023-4-6 09:15:41
     */
    private static int[] fairCandySwap1(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        HashMap<Integer, List<Integer>> aliceCandyAndIndex = new HashMap<>();
        for (int i = 0; i < aliceSizes.length; i++) {
            int aliceSize = aliceSizes[i];
            List<Integer> orDefault = aliceCandyAndIndex.getOrDefault(aliceSize, new ArrayList<>());
            orDefault.add(i);
            aliceCandyAndIndex.put(aliceSize, orDefault);
            aliceSum += aliceSize;
        }
        HashMap<Integer, List<Integer>> bobCandyAndIndex = new HashMap<>();
        for (int i = 0; i < bobSizes.length; i++) {
            int bobSize = bobSizes[i];
            List<Integer> orDefault = bobCandyAndIndex.getOrDefault(bobSize, new ArrayList<>());
            orDefault.add(i);
            bobCandyAndIndex.put(bobSize, orDefault);
            bobSum += bobSize;
        }
        // 糖果差值
        HashMap<Integer, List<int[]>> candyDifference = new HashMap<>();
        for (Integer alice : aliceCandyAndIndex.keySet()) {
            for (Integer bob : bobCandyAndIndex.keySet()) {
                int abs = alice - bob;
                List<int[]> orDefault = candyDifference.getOrDefault(abs, new ArrayList<>());
                orDefault.add(new int[] {alice, bob});
                candyDifference.put(abs, orDefault);
            }
        }
        int[] result = {0, 0};
        if (aliceSum == bobSum) {
            return result;
        } else {
            int moreNum = aliceSum - bobSum;
            List<int[]> ints = candyDifference.get(moreNum / 2);
            if (ints != null) {
                return ints.get(0);
            } else {
                return null;
            }
        }
    }
}
