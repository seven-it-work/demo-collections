/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;

/**
 * 1144. 递减元素使数组呈锯齿状 <a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/">...</a>
 *
 * @date 2023/2/27 8:49
 */
public class Solution1144 {
    public static int movesToMakeZigzag(int[] nums) {
        return movesToMakeZigzag2(nums);
    }

    /**
     * 2023-3-2 09:35:08
     * 时间 0 ms 击败 100% 内存 38.7 MB 击败 86.34%
     * <P>借鉴官方解答</P>
     *
     * @param nums
     * @return
     */
    public static int movesToMakeZigzag2(int[] nums) {
        int countStart0 = 0;
        // 从0开始判断，也就是判断奇数位
        for (int i = 0; i < nums.length; i += 2) {
            int tempCount = 0;
            if (i - 1 >= 0) {
                // 当前位数值>上一个，就取其差，保证当前为<上一位
                tempCount = Math.max(tempCount, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                // 当前位数值>下一个，就取其差，保证当前为<下一位
                tempCount = Math.max(tempCount, nums[i] - nums[i + 1] + 1);
            }
            countStart0 += tempCount;
        }

        int countStart1 = 0;
        for (int i = 1; i < nums.length; i += 2) {
            int tempCount = 0;
            if (i - 1 >= 0) {
                tempCount = Math.max(tempCount, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                tempCount = Math.max(tempCount, nums[i] - nums[i + 1] + 1);
            }
            countStart1 += tempCount;
        }
        return Math.min(countStart0, countStart1);
    }

    /**
     * 作者：力扣官方题解
     * 链接：<a href="https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/solutions/2134526/di-jian-yuan-su-shi-shu-zu-cheng-ju-chi-o30ye/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    private static int movesToMakeZigzagSolution1(int[] nums) {
        return Math.min(help(nums, 0), help(nums, 1));
    }

    private static int help(int[] nums, int pos) {
        int res = 0;
        for (int i = pos; i < nums.length; i += 2) {
            int a = 0;
            if (i - 1 >= 0) {
                a = Math.max(a, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                a = Math.max(a, nums[i] - nums[i + 1] + 1);
            }
            res += a;
        }
        return res;
    }

    /**
     * 奇数位，要么比左右小，要么比左右大
     * <P>没有通过</P>
     */
    private static int movesToMakeZigzag1(int[] nums) {
        int min = Integer.MAX_VALUE;
        min = Math.min(bianXiao(nums), min);
        min = Math.min(bianXiaoSelf(nums), min);
        return min;
    }

    private static int bianXiao(int[] nums) {
        int[] dpNum1 = new int[nums.length];
        int[] temp1 = nums.clone();
        for (int i = 1; i < nums.length - 1; i += 2) {
            // 都小的情况
            if (temp1[i - 1] >= temp1[i]) {
                dpNum1[i - 1] += temp1[i - 1] - temp1[i] + 1;
                temp1[i - 1] = temp1[i - 1] - dpNum1[i - 1];
            }
            if (temp1[i + 1] >= temp1[i]) {
                dpNum1[i + 1] += temp1[i + 1] - temp1[i] + 1;
                temp1[i + 1] = temp1[i + 1] - dpNum1[i + 1];
            }
        }
        return Arrays.stream(dpNum1).sum();
    }

    private static int bianXiaoSelf(int[] nums) {
        int[] dpNum1 = new int[nums.length];
        int[] temp1 = nums.clone();
        for (int i = 1; i < nums.length - 1; i += 2) {
            if (temp1[i - 1] <= temp1[i]) {
                dpNum1[i] += temp1[i] - temp1[i - 1] + 1;
                temp1[i] = temp1[i] - dpNum1[i];
            }
            if (temp1[i + 1] <= temp1[i]) {
                dpNum1[i] += temp1[i] - temp1[i + 1] + 1;
                temp1[i] = temp1[i] - dpNum1[i];
            }
        }
        return Arrays.stream(dpNum1).sum();
    }
}
