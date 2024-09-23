/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 * https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/solutions/22785/zui-duo-neng-wan-cheng-pai-xu-de-kuai-ii-deng-jie-/
 * @author yijialuo
 * @since 2022/10/13 10:32
 */
public class Solution769 {

    public static int maxChunksToSorted(int[] arr) {
        return maxChunksToSorted3(arr);
    }

    /**
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted/solutions/1886333/zui-duo-neng-wan-cheng-pai-xu-de-kuai-by-gc4k/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int maxChunksToSorted3(int[] arr) {
        int m = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if (m == i) {
                res++;
            }
        }
        return res;
    }

    /**
     * 放弃！！！
     * 0,3,1,2
     * 2022/10/13 11:13:57
     */
    private static int maxChunksToSorted2(int[] arr) {
        final Set<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        final Stack<Integer> stack = new Stack<>();
        int stackMax = Integer.MIN_VALUE;
        int count = 0;
        for (int i : arr) {
            if (stack.isEmpty()) {
                stack.add(i);
                collect.remove(i);
                stackMax = i;
            } else if (i < stackMax) {
                stack.add(i);
                collect.remove(i);
            } else if (i <= collect.stream().min(Comparator.comparingInt(integer -> integer)).get()) {
                stack.clear();
                stack.add(i);
                collect.remove(i);
                stackMax = i;
                count++;
            } else {
                stack.add(i);
                collect.remove(i);
            }
        }
        if (!stack.isEmpty()) {
            count++;
        }
        return count;
    }

    /**
     * 思路有问题
     * 2022/10/13 10:50:57
     */
    private static int maxChunksToSorted1(int[] arr) {
        final HashMap<Integer, Integer> valueAndIndex = new HashMap<>();
        final int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            valueAndIndex.put(arr[i], i);
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            final Integer index = valueAndIndex.get(temp[i]);
            count++;
            if (index != i) {
                i = index;
            }
        }
        return count;
    }
}
