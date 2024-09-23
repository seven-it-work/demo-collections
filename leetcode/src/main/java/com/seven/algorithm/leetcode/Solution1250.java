package com.seven.algorithm.leetcode;

public class Solution1250 {
    public static boolean isGoodArray(int[] nums) {
        return isGoodArraySolution1(nums);
    }

    /**
     * 官方题解：https://leetcode.cn/problems/check-if-it-is-a-good-array/solutions/2110763/jian-cha-hao-shu-zu-by-leetcode-solution-qg2h/
     *
     * @param nums
     * @return
     */
    private static boolean isGoodArraySolution1(int[] nums) {
        int result = nums[0];
        for (int num : nums) {
            result = gcd(result, num);
            if (result == 1) {
                break;
            }
        }
        return result == 1;
    }

    private static int gcd(int result, int num) {
        while (num != 0) {
            int temp = result;
            result = num;
            num = temp % result;
        }
        return result;
    }
}
