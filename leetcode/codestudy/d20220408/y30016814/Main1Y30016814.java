/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.codestudy.d20220408.y30016814;

import com.huawei.codestudy.d20220408.Main1;

import java.util.Stack;

/**
 * 耗时15分钟
 *
 * @author yijialuo
 * @since 2022/4/24 9:36
 */
public class Main1Y30016814 extends Main1 {
    public static void main(String[] args) {
        Main1Y30016814 main1Y30016814 = new Main1Y30016814();
        main1Y30016814.getMaxDepth("(1+(2*3)+((8)/4))+1");
    }

    @Override
    public int getMaxDepth(String inputStr) {
        Stack<String> stringStack = new Stack<>();
        int maxTemp = 0;
        int max = 0;
        for (char c : inputStr.toCharArray()) {
            if (c == '(') {
                stringStack.push("(");
            } else if (c == ')') {
                int size = stringStack.size();
                maxTemp = Math.max(size, maxTemp);
                if (size == 1) {
                    max = Math.max(maxTemp, max);
                    maxTemp = 0;
                }
                stringStack.pop();
            }
        }
        return max;
    }
}
