package com.seven.algorithm.leetcode;

import java.util.HashMap;

public class Solution1814 {

    public static int countNicePairs(int[] nums) {
        return countNicePairsSolution(nums);
    }

    /**
     * https://leetcode.cn/problems/count-nice-pairs-in-an-array/solutions/2064186/tong-ji-yi-ge-shu-zu-zhong-hao-dui-zi-de-ywux/
     *
     * @param nums
     * @return
     */
    public static int countNicePairsSolution(int[] nums) {
        // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        // nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        HashMap<Integer, Integer> resultAndCountMap = new HashMap<>();
        int result = 0;
        final int mod = 1000000007;
        for (int num : nums) {
            int temp = num - rev2(num);
            result = (result + resultAndCountMap.getOrDefault(temp, 0)) % mod;
            resultAndCountMap.put(temp, resultAndCountMap.getOrDefault(temp, 0) + 1);
        }
        return result;
    }

    /**
     * 记住这个算法，非常经典的数字反转算法
     *
     * @param num 待反转数字
     * @return 反转后的结果
     */
    public static int rev2(int num) {
        int temp = num;
        int result = 0;
        while (temp > 0) {
            result = result * 10 + temp % 10;
            temp = temp / 10;
        }
        return result;
    }

    /**
     * 暴力，超时
     *
     * @param nums
     * @return
     */
    public static int countNicePairs1(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])) {
                    result++;
                }
            }
        }
        double v = result % (Math.pow(10, 9) + 7);
        return (int) v;
    }

    private static int rev(int num) {
        return Integer.parseInt(new StringBuffer().append(num).reverse().toString());
    }
}
