/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode.interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/
 *
 * @author yijialuo
 * @since 2022/9/28 9:36
 */
public class Interview1709NO {
    private static final ArrayList<Integer> NUM_LIST = new ArrayList<>(Arrays.asList(1, 3, 5, 7));

    public static int getKthMagicNumber(int k) {
        return getKthMagicNumberAnswer1(k);
    }

    /**
     * 作者：muse-77
     * 链接：https://leetcode.cn/problems/get-kth-magic-number-lcci/solution/zhua-wa-mou-si-by-muse-77-x2i4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int getKthMagicNumberAnswer1(int k) {
        int index1 = 0, index2 = 0, index3 = 0;
        int[] result = new int[k];
        result[0] = 1;
        for (int i = 1; i < k; i++) {
            int minValue = Math.min(Math.min(3 * result[index1], 5 * result[index2]), 7 * result[index3]);
            if (minValue == 3 * result[index1]) {
                index1++;
            }
            if (minValue == 5 * result[index2]) {
                index2++;
            }
            if (minValue == 7 * result[index3]) {
                index3++;
            }
            result[i] = minValue;
        }
        return result[k - 1];
    }

    /**
     * 没有通过，因为不理解题意，后续理解了但是找不到规律
     * 提交测试2次
     * 2022/09/28 11:06:47
     */
    public static int getKthMagicNumber1(int k) {
        final int size = NUM_LIST.size();
        if (k < size) {
            return NUM_LIST.get(k - 1);
        } else {
            // 截取最后3个
            final List<Integer> integers = new ArrayList<>(NUM_LIST).subList(size - 3, size);
            for (int i = 0; i < integers.size(); i++) {
                for (int j = i; j < integers.size(); j++) {
                    NUM_LIST.add(integers.get(i) * integers.get(j));
                }
            }
            return getKthMagicNumber(k);
        }
    }
}
