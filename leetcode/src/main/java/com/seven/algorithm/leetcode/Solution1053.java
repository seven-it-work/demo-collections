/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1053. 交换一次的先前排列 https://leetcode.cn/problems/previous-permutation-with-one-swap/description/
 *
 * @date 2023/4/3 8:54
 */
public class Solution1053 {
    public static int[] prevPermOpt1(int[] arr) {
        return prevPermOpt1Solution1(arr);
    }

    /**
     * https://leetcode.cn/problems/previous-permutation-with-one-swap/solutions/2205409/jian-dan-yi-dong-javazai-suo-you-java-ti-xk82/
     * 2023-4-3 09:22:56
     *
     * @param arr
     * @return
     */
    private static int[] prevPermOpt1Solution1(int[] arr) {
        // 先倒序找出小的
        int left = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                left = i - 1;
                break;
            }
        }
        // 倒序找到第一个小于left
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] == arr[i - 1]) {
                continue;
            } else if (arr[i] < arr[left]) {
                int temp = arr[left];
                arr[left] = arr[i];
                arr[i] = temp;
                return arr;
            }
        }
        return arr;
    }

    /**
     * 暴力
     * 存在问题...
     * 2023-4-3 09:19:11
     *
     * @param arr
     * @return
     */
    private static int[] prevPermOpt11(int[] arr) {
        int[] dest = new int[arr.length];
        HashMap<Integer, List<Integer>> valueAndIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            List<Integer> orDefault = valueAndIndex.getOrDefault(key, new ArrayList<>());
            orDefault.add(i);
            valueAndIndex.put(key, orDefault);
            dest[i] = key;
        }
        for (int i = dest.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (dest[i] < dest[j]) {
                    Integer integer = valueAndIndex.get(dest[i]).get(0);
                    int temp = dest[integer];
                    dest[integer] = dest[j];
                    dest[j] = temp;
                    return dest;
                }
            }
        }
        return dest;
    }
}
