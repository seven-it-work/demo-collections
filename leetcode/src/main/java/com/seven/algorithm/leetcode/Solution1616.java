/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 1616. 分割两个字符串得到回文串 https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
 *
 * @date 2023/3/15 9:03
 */
public class Solution1616 {
    public static boolean checkPalindromeFormation(String a, String b) {
        return checkPalindromeFormation1(a, b);
    }


    /**
     * <p>
     * 分析：
     * ulacfd
     * jizalu->反转
     * ulazij
     * cfdzij->反转
     * jizdfc
     * jizalu
     * 存在场景遗漏
     * </P>
     * 2023/03/15 09:20
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean checkPalindromeFormation1(String a, String b) {
        // 反转a
        String reverseStrA = new StringBuilder(a).reverse().toString();
        // 反转b
        String reverseStrB = new StringBuilder(b).reverse().toString();
        if (reverseStrA.equals(a) || reverseStrB.equals(b)) {
            return true;
        }
        return reverseStrA.charAt(0) == b.charAt(0) || reverseStrB.charAt(0) == a.charAt(0);
    }

    /**
     * 暴力
     * 超时
     * 2023-3-15 09:31:16
     */
    private static boolean checkPalindromeFormation2(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            String tempA = a.substring(0, i);
            String tempB = b.substring(i);
            if (stringBuilder.append(tempA).append(tempB).reverse().toString().equals(tempA + tempB)) {
                return true;
            }
            stringBuilder = new StringBuilder();
            tempA = a.substring(i);
            tempB = b.substring(0, i);
            if (stringBuilder.append(tempB).append(tempA).reverse().toString().equals(tempB + tempA)) {
                return true;
            }
        }
        return false;
    }
}
