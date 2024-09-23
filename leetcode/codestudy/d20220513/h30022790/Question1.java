/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220513.h30022790;

import com.huawei.codestudy.d20220513.Main1;

public class Question1 extends Main1 {
    @Override
    public int getMaxQuantity(int[] productions, int[] plans, int window) {
        int sum = 0;
        for (int i = 0; i < productions.length; i++) {
            if (plans[i] == 1) {
                sum += productions[i];
                productions[i] = 0;
            }
        }
        int current = 0;
        int max = 0;
        for (int i = 0; i < productions.length; i++) {
            current += productions[i];
            if (i >= window) {
                current -= productions[i - window];
            }
            max = Math.max(max, current);
        }
        return sum + max;
    }
}
