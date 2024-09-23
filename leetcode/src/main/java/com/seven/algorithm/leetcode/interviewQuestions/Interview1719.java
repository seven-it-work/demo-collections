/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode.interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/missing-two-lcci/
 *
 * @author yijialuo
 * @since 2022/9/26 10:01
 */
public class Interview1719 {
    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗： 42.8 MB , 在所有 Java 提交中击败了 96.81% 的用户
     *     2022/09/26 10:47:25
     */
    public static int[] missingTwo(int[] nums) {
        final int[] ints = Arrays.stream(nums).sorted().toArray();
        final ArrayList<Integer> result = new ArrayList<>();
        int lastNum = 1;
        for (int num : ints) {
            if (result.size() == 2) {
                break;
            }
            if (num == lastNum) {
                lastNum = num + 1;
            } else {
                result.add(lastNum);
                while (true) {
                    if (result.size() == 2) {
                        break;
                    }
                    if (lastNum < num - 1) {
                        lastNum++;
                        result.add(lastNum);
                    } else {
                        lastNum = num + 1;
                        break;
                    }
                }
            }
        }
        if (result.size() != 2) {
            final int size = result.size();
            for (int i = size; i < 2; i++) {
                result.add(lastNum);
                lastNum++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
