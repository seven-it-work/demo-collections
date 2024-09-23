package com.seven.algorithm.leetcode;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 */
public class Solution977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new Solution977().sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }


    /**
     * 2024-9-8 15:52:09
     * 直接暴力循环，平方后在进行排序
     * 2024-9-8 15:55:03
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(num -> num * num).sorted().toArray();
    }

}
