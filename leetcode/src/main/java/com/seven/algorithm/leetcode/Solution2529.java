package com.seven.algorithm.leetcode;

public class Solution2529 {
    public static void main(String[] args) {
    }

    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg++;
            } else if (nums[i] > 0) {
                pos++;
            }
        }
        return Math.max(pos, neg);
    }
}
