/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220513.y30016814;

import com.huawei.codestudy.d20220513.Main1;

import java.util.ArrayList;

/**
 * 耗时：23min，未经过大用例测试，感觉会超时
 * 经过随机用例测试，感觉AC了。。
 *
 * @author yijialuo
 * @since 2022/5/20 9:14
 */
public class Question1 extends Main1 {
    @Override
    public int getMaxQuantity(int[] productions, int[] plans, int window) {
        int temp1 = 0;
        // 找到plans从0开始的第window个
        final ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            if (plans[i] == 0) {
                if (i <= plans.length - window) {
                    index.add(i);
                }
            } else {
                temp1 += productions[i];
            }
        }
        int maxValue = 0;
        for (Integer in : index) {
            int temp0 = 0;
            for (int i = in; i < window + in; i++) {
                if (plans[i] == 0) {
                    temp0 += productions[i];
                }
            }
            maxValue = Math.max(maxValue, temp0);
        }
        return temp1 + maxValue;
    }
}
