/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yijialuo
 * @since 2022/5/28 11:33
 */
public class Solution347 {
    private Solution347 solution347;

    public int[] topKFrequent(int[] nums, int k) {
        return this.solutionViolence(nums, k);
    }

    @BeforeEach
    void before() {
        solution347 = new Solution347();
    }

    @Test
    void case1() {
        final int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        int k = 2;
        final int[] except = new int[] {1, 2};
        final int[] result = solution347.topKFrequent(nums, k);
        Assertions.assertArrayEquals(except, result);
    }

    /**
     * 执行用时：19 ms, 在所有 Java 提交中击败了5.17%的用户
     * 内存消耗：44.1 MB, 在所有 Java 提交中击败了18.53%的用户
     * 暴力求解
     *
     * @param nums nums
     * @param k k
     * @return result
     */
    private int[] solutionViolence(int[] nums, int k) {
        final HashMap<Integer, Integer> numAndTimes = new HashMap<>();
        for (int num : nums) {
            numAndTimes.put(num, 1 + numAndTimes.getOrDefault(num, 0));
        }
        return numAndTimes.entrySet()
            .stream()
            .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList())
            .subList(0, k)
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
