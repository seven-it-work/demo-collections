/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2363. 合并相似的物品 <a href="https://leetcode.cn/problems/merge-similar-items/">...</a>
 *
 * @date 2023/2/28 8:56
 */
public class Solution2363 {
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        return mergeSimilarItems1(items1, items2);
    }

    /**
     * 2023-2-28 09:01:42
     * 时间 9 ms 击败 39.30% 内存 42.2 MB 击败 63.51%
     *
     * @param items1
     * @param items2
     * @return
     */
    private static List<List<Integer>> mergeSimilarItems1(int[][] items1, int[][] items2) {
        HashMap<Integer, Integer> valueAndWeight = new HashMap<>();
        for (int[] ints : items1) {
            valueAndWeight.put(ints[0], valueAndWeight.getOrDefault(ints[0], 0) + ints[1]);
        }
        for (int[] ints : items2) {
            valueAndWeight.put(ints[0], valueAndWeight.getOrDefault(ints[0], 0) + ints[1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        valueAndWeight.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry -> {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        });
        return result;
    }
}
