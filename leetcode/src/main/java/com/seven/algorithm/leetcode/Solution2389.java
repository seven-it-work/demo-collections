/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;


public class Solution2389 {
    public static int[] answerQueries(int[] nums, int[] queries) {
        return answerQueriesSolution1(nums, queries);
    }

    /**
     * 2023年3月17日09:48:06
     * @param nums
     * @param queries
     * @return
     */
    private static int[] answerQueries1(int[] nums, int[] queries) {
        return null;
    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/longest-subsequence-with-limited-sum/solutions/2172081/he-you-xian-de-zui-chang-zi-xu-lie-by-le-xqox/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param nums
     * @param queries
     * @return
     */
    private static int[] answerQueriesSolution1(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        Arrays.sort(nums);
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = f[i] + nums[i];
        }
        int[] answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = binarySearch(f, queries[i]) - 1;
        }
        return answer;
    }

    private static int binarySearch(int[] f, int target) {
        int low = 1, high = f.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
