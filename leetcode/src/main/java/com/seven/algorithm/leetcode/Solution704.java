/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;


import com.seven.algorithm.utils.TransformUtils;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/binary-search/
 */
public class Solution704 {
    public static void main(String[] args) {
        System.out.println(new Solution704().search(TransformUtils.intArrays("[-1,0,3,5,9,12]"), 2));
//        System.out.println(new Solution704().search(TransformUtils.intArrays("[2,5]"), 2));
//        System.out.println(new Solution704().search(TransformUtils.intArrays("[-1,0,5]"), 5));
    }

    /**
     * 2024年9月19日
     * 暴力遍历
     * 2024年9月19日
     * 执行用时分布1ms击败6.44%复杂度分析消耗内存分布44.56MB击败75.64%
     *
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分法
     * 2024年9月19日
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        while (left + 1 < right) {
            mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
