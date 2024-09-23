/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 *
 * @author yijialuo
 * @since 2022/10/19 14:37
 */
public class Solution1700 {
    public static int countStudents(int[] students, int[] sandwiches) {
        return countStudents1(students, sandwiches);
    }

    /**
     * 2022/10/19 14:52:58
     * 时间 1 ms 击败 46.51%
     * 内存 39.7 MB 击败 23.26%
     * 暴力正解
     */
    private static int countStudents1(int[] students, int[] sandwiches) {
        final LinkedList<Integer> studentLinked = new LinkedList<>();
        for (int student : students) {
            studentLinked.addLast(student);
        }
        int studentCount = studentLinked.size();
        int tempCount = 0;
        for (int i = 0; i < sandwiches.length; i++) {
            final Integer first = studentLinked.removeFirst();
            tempCount++;
            if (first != sandwiches[i]) {
                if (tempCount == studentCount) {
                    return studentLinked.size() + 1;
                }
                studentLinked.addLast(first);
                i--;
            } else {
                studentCount = studentLinked.size();
                tempCount = 0;
            }
        }
        return studentLinked.size();
    }
}
