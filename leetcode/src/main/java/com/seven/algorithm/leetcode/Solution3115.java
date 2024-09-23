package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

public class Solution3115 {
    public static void main(String[] args) {
        System.out.println(new Solution3115().maximumPrimeDifference(TransformUtils.intArrays("[4,2,9,5,3]")));// 3
        System.out.println(new Solution3115().maximumPrimeDifference(TransformUtils.intArrays("[4,8,2,8]")));// 0
    }

    public int maximumPrimeDifference(int[] nums) {
        int minIndex = nums.length;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (isItAPrimeNumber(nums[i])) {
                minIndex = Math.min(i, minIndex);
                maxIndex = Math.max(i, maxIndex);
            }
        }
        if (maxIndex == -1) {
            return 0;
        }
        return maxIndex - minIndex;
    }

    private boolean isItAPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
