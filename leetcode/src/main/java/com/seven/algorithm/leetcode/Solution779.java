/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/k-th-symbol-in-grammar/
 *
 * @author yijialuo
 * @since 2022/10/20 15:10
 */
public class Solution779 {

    private static final Map<Integer, String> MEMORANDUM = new HashMap<>();

    static {
        MEMORANDUM.put(1, "0");
        MEMORANDUM.put(2, "01");
        MEMORANDUM.put(3, "0110");
        MEMORANDUM.put(4, "01101001");
    }

    public static int kthGrammar(int n, int k) {
        return kthGrammar3(n, k);
    }

    /**
     * 时间 0 ms 击败 100% 内存 38.7 MB 击败 5.8%
     */
    private static int kthGrammar3(int n, int k) {
        int ans = 0;
        while (k != 1) {
            if (k % 2 == 0) {
                ans ^= 1;
            }
            k = (k + 1) / 2;
        }
        return ans;
    }

    /**
     * 超出内存限制
     * 2022/10/20 15:38:28
     */
    private static int kthGrammar2(int n, int k) {
        String str;
        if (n <= 4) {
            if (n == 1) {
                str = "0";
            } else if (n == 2) {
                str = "01";
            } else if (n == 3) {
                str = "0110";
            } else {
                str = "01101001";
            }
        } else {
            str = "01101001";
            for (int i = 0; i < n - 4; i++) {
                str = str + new StringBuilder(str).reverse();
            }
        }
        return str.charAt(k - 1) == '0' ? 0 : 1;
    }

    /**
     * 超出内存限制
     * 2022/10/20 15:25:19
     */
    private static int kthGrammar1(int n, int k) {
        final String str = getStr(n);
        return str.charAt(k - 1) == '0' ? 0 : 1;
    }

    private static String getStr(int n) {
        if (n == 1) {
            MEMORANDUM.put(n, "0");
        }
        final String s = MEMORANDUM.get(n);
        if (s == null) {
            final String str = getStr(n - 1);
            StringBuilder newStr = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    newStr.append("01");
                } else {
                    newStr.append("10");
                }
            }
            MEMORANDUM.put(n, newStr.toString());
            return newStr.toString();
        } else {
            return s;
        }
    }
}
