/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1096. 花括号展开 II https://leetcode.cn/problems/brace-expansion-ii/
 *
 * @date 2023/3/7 8:43
 */
public class Solution1096 {

    public static List<String> braceExpansionII(String expression) {
        return braceExpansionII1(expression);
    }

    /**
     * 差一点点，就差一点点...
     * 2023-3-7 10:02:08
     */
    private static List<String> braceExpansionII1(String expression) {
        Set<String> resultList = new HashSet<>();
        String[] split = expression.replace(",{", ",").split("},");
        for (String s : split) {
            char[] chars = s.toCharArray();
            Set<String> pre = new HashSet<>();
            Set<String> result = new HashSet<>();
            String temp = "";
            // 这里是否存在 {ab,bc}这样的
            for (char aChar : chars) {
                if (aChar == '{') {
                    if (!temp.equals("")) {
                        result.add(temp);
                    }
                    temp = "";
                    pre = changeIt(pre, result);
                    result = new HashSet<>();
                } else if (aChar == '}') {
                    if (!temp.equals("")) {
                        result.add(temp);
                    }
                    temp = "";
                    pre = changeIt(pre, result);
                    result = new HashSet<>();
                } else if (aChar == ',') {
                    result.add(temp);
                    temp = "";
                } else {
                    temp += aChar;
                }
            }
            if (!temp.equals("")) {
                result.add(temp);
            }
            if (!result.isEmpty()) {
                pre = changeIt(pre, result);
            }
            resultList.addAll(pre);
        }
        return resultList.stream().sorted().collect(Collectors.toList());
    }

    private static Set<String> changeIt(Set<String> pre, Set<String> result) {
        if (pre.isEmpty()) {
            return result;
        }
        if (result.isEmpty()) {
            return pre;
        }
        Set<String> temp = new HashSet<>();
        for (String s : pre) {
            for (String s1 : result) {
                temp.add(s + s1);
            }
        }
        return temp;
    }
}
