package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

import java.util.Arrays;


public class Solution2576 {
    public static void main(String[] args) {
        System.out.println(new Solution2576().maxNumOfMarkedIndices(TransformUtils.intArrays("[3,5,2,4]")));
        System.out.println(new Solution2576().maxNumOfMarkedIndices(TransformUtils.intArrays("[9,2,5,4]")));
        System.out.println(new Solution2576().maxNumOfMarkedIndices(TransformUtils.intArrays("[7,6,8]")));
        System.out.println(new Solution2576().maxNumOfMarkedIndices(TransformUtils.intArrays(
            "[1,78,27,48,14,86,79,68,77,20,57,21,18,67,5,51,70,85,47,56,22,79,41,8,39,81,59,74,14,45,49,15,10,28,16,77,22,65,8,36,79,94,44,80,72,8,96,78,39,92,69,55,9,44,26,76,40,77,16,69,40,64,12,48,66,7,59,10]")));
    }

    private static boolean isaBoolean(int[] nums, int left, int right) {
        return 2 * nums[left] <= nums[right];
    }

    /**
     * 2024-9-12 09:52:12
     * <p>
     * 2024-9-12 10:37:05
     * 第二次解答
     * 2024-9-12 14:00:56
     *
     * 2024-9-12 14:29:58
     *
     * @param nums
     * @return
     */
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int count = 0;
        int right = nums.length / 2;
        while (true) {
            if (left >= nums.length / 2 || right >= nums.length) {
                return count *2 ;
            }
            if (isaBoolean(nums, left, right)) {
                left++;
                right++;
                count++;
            } else {
                right++;
            }
        }
    }
}
