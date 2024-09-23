package com.seven.algorithm.leetcode;

import java.util.HashMap;

public class Solution2341 {
    public static int[] numberOfPairs(int[] nums) {
        return numberOfPairs1(nums);
    }

    /**
     * 2023-2-16 08:23:34
     * 时间 2 ms 击败 16% 内存 40.5 MB 击败 18%
     * 2023-2-16 08:30:03
     */
    private static int[] numberOfPairs1(int[] nums) {
        HashMap<Integer, Integer> numberAndSizeMap = new HashMap<>();
        for (int num : nums) {
            numberAndSizeMap.put(num, numberAndSizeMap.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[] {0, 0};
        numberAndSizeMap.values().forEach(size -> {
            int aCoupleOfPairs = size / 2;
            if (size % 2 == 0) {
                result[0] += aCoupleOfPairs;
            } else {
                result[0] += aCoupleOfPairs;
                result[1] += size - aCoupleOfPairs * 2;
            }
        });
        return result;
    }
}
