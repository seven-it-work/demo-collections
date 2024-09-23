/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2022-2022. All rights reserved.
 */

package com.huawei.codestudy.d20220408.h30022790;

import com.huawei.codestudy.d20220408.Main1;

import java.util.Stack;

public class Question1 extends Main1 {
    @Override
    public int getMaxDepth(String inputStr) {
        if (inputStr.indexOf('(') == -1 || inputStr.indexOf(')') == -1) {
            return 0;
        }
        char[] chars = inputStr.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            pushToStack(stack, aChar);
        }
        char[] datas = new char[stack.size()];
        int index = 1;
        while (!stack.isEmpty()) {
            datas[datas.length - index++] = stack.pop();
        }
        return 1 + getMaxDepth(new String(datas));
    }

    private void pushToStack(Stack<Character> stack, char aChar) {
        if (aChar == '(' || aChar == ')') {
            boolean push = false;
            if (aChar == ')' && stack.peek() == '(') {
                stack.pop();
                stack.push('a');
                push = true;
            }
            if (!push) {
                stack.push(aChar);
            }
        }
    }
}
