/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. 使数组和能被 P 整除 https://leetcode.cn/problems/make-sum-divisible-by-p/
 *
 * @date 2023/3/10 8:45
 */
public class Solution1590 {
    public static int minSubarray(int[] nums, int p) {
        return minSubarraySolution1(nums, p);
    }

    /**
     * 理解错误题意：
     * <P>理解为了：剩余的子字符串为原数组的连续元素</P>
     */
    private static int minSubarray1_1(int[] nums, int p) {
        // 滑动窗口
        for (int size = nums.length; size >= 0; size--) {
            long sum = 0;
            for (int i = 0; i < size; i++) {
                sum += nums[i];
            }
            if (sum % p == 0) {
                return nums.length - size;
            }
            // 滑动
            for (int i = 1; i <= nums.length - size; i++) {
                sum -= nums[i - 1];
                sum += nums[i + nums.length - size];
                if (sum % p == 0) {
                    return nums.length - size;
                }
            }
        }
        return -1;
    }

    private static int minSubarray1(int[] nums, int p) {
        // 求和
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % p == 0) {
            return 0;
        }
        // 滑动窗口
        for (int size = 0; size < nums.length - 1; size++) {
            long numberToBeSubtracted = 0;
            for (int i = 0; i <= size; i++) {
                numberToBeSubtracted += nums[i];
            }
            for (int i = 1; i < nums.length - size; i++) {
                numberToBeSubtracted -= nums[i - 1];
                numberToBeSubtracted += nums[i + size];
                if ((sum - numberToBeSubtracted) % p == 0) {
                    return size + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/make-sum-divisible-by-p/solutions/2157277/shi-shu-zu-he-neng-bei-p-zheng-chu-by-le-dob9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int minSubarraySolution1(int[] nums, int p) {
        int x = 0;
        for (int num : nums) {
            x = (x + num) % p;
        }
        if (x == 0) {
            return 0;
        }
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        int y = 0, res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            index.put(y, i); // f[i] mod p = y，因此哈希表记录 y 对应的下标为 i
            y = (y + nums[i]) % p;
            if (index.containsKey((y - x + p) % p)) {
                res = Math.min(res, i - index.get((y - x + p) % p) + 1);
            }
        }
        return res == nums.length ? -1 : res;
    }
}
