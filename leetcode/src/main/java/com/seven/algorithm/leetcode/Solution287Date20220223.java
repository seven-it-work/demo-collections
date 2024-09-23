package com.seven.algorithm.leetcode;

import java.util.HashSet;

/**
 * #### [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/)
 * <p>
 * 难度中等1588收藏分享切换为英文接收动态反馈
 * <p>
 * 给定一个包含 `n + 1` 个整数的数组 `nums` ，其数字都在 `[1, n]` 范围内（包括 `1` 和 `n`），可知至少存在一个重复的整数。
 * <p>
 * 假设 `nums` 只有 **一个重复的整数** ，返回 **这个重复的数** 。
 * <p>
 * 你设计的解决方案必须 **不修改** 数组 `nums` 且只用常量级 `O(1)` 的额外空间。
 * <p>
 * <p>
 * <p>
 * **示例 1：**
 * <p>
 * ```
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * ```
 * <p>
 * **示例 2：**
 * <p>
 * ```
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * ```
 * <p>
 * <p>
 * <p>
 * **提示：**
 * <p>
 * - `1 <= n <= 105`
 * - `nums.length == n + 1`
 * - `1 <= nums[i] <= n`
 * - `nums` 中 **只有一个整数** 出现 **两次或多次** ，其余整数均只出现 **一次**
 * <p>
 * <p>
 * <p>
 * **进阶：**
 * <p>
 * - 如何证明 `nums` 中至少存在一个重复的数字?
 * - 你可以设计一个线性级时间复杂度 `O(n)` 的解决方案吗？
 */
public class Solution287Date20220223 {
    public int findDuplicate(int[] nums) {
        return findDuplicate202202232203(nums);
    }

    /**
     * 执行用时：23 ms, 在所有 Java 提交中击败了37.89%的用户
     * 内存消耗：57.5 MB, 在所有 Java 提交中击败了29.41%的用户
s     */
    public int findDuplicate202202232203(int[] nums) {
        HashSet<Integer> integers = new HashSet<Integer>();
        for (int num : nums) {
            if (integers.contains(num)) {
                return num;
            } else {
                integers.add(num);
            }
        }
        return 0;
    }
}
