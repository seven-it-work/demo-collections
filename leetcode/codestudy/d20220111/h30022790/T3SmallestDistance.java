/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220111.h30022790;

import com.huawei.codestudy.d20220111.T3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述
 *
 * @author h30022790
 * @since 2022-01-18
 */
public class T3SmallestDistance extends T3 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 3};
        System.out.println(new T3SmallestDistance().smallestDistancePair(nums, 6));
    }

    /**
     * 0 0 1 1 1 1 2 2 2 2
     * @param nums 坐标位置
     * @param k 第k个最小距离
     * @return
     */
    @Override
    public int smallestDistancePair(int[] nums, int k) {
        return 0;
        // return smallestDistancePairSimple(nums, k);
    }

    private int smallestDistancePairSimple(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                list.add(Math.abs(nums[i] - nums[j]));
            }
        }
        Collections.sort(list);
        return list.get(k - 1);
    }
}
