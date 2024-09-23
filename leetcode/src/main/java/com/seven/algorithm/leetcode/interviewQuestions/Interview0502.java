/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode.interviewQuestions;

/**
 * 面试题 05.02. 二进制数转字符串 <a href="https://leetcode.cn/problems/bianry-number-to-string-lcci/description/">面试题 05.02. 二进制数转字符串</a>
 *
 * @date 2023/3/2 8:43
 */
public class Interview0502 {
    public static void main(String[] args) {

    }

    public static String printBin(double num) {
        return printBin1(num);
    }

    /**
     * 时间 0 ms 击败 100% 内存 38.9 MB 击败 41.96%
     * 2023-3-2 09:15:48
     *
     * @param num
     * @return
     */
    private static String printBin1(double num) {
        if (num < 0) {
            return "ERROR";
        } else {
            num = num * 2;
            String s = toBinaryString(num, new StringBuilder());
            return s.equals("ERROR") ? s : "0." + s;
        }
    }

    private static String toBinaryString(double num, StringBuilder stringBuilder) {
        if (stringBuilder.length() > 32) {
            return "ERROR";
        }
        if (num == 0) {
            return stringBuilder.toString();
        } else if (num >= 1) {
            stringBuilder.append("1");
            num = num - 1;
            num = num * 2;
            return toBinaryString(num, stringBuilder);
        } else {
            stringBuilder.append("0");
            num = num * 2;
            return toBinaryString(num, stringBuilder);
        }
    }
}
