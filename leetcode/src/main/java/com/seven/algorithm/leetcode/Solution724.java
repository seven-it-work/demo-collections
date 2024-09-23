package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

public class Solution724 {
    public static void main(String[] args) {
        System.out.println(new Solution724().pivotIndex(TransformUtils.intArrays("[1, 7, 3, 6, 5, 6]")));// 3
        System.out.println(new Solution724().pivotIndex(TransformUtils.intArrays("[1, 2, 3]")));// -1
    }

    public int pivotIndex(int[] nums) {
        // 先求和
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        if (rightSum == leftSum) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
