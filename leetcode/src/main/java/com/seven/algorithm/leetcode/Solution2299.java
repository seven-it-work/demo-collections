package com.seven.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2299 {
    private static final Set<Character> SPECIAL_CHAR_SET = new HashSet<>(
        Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

    public static boolean strongPasswordCheckerII(String password) {
        return strongPasswordCheckerII1(password);
    }

    /**
     * 时间 1 ms 击败 69.57% 内存 39.1 MB 击败 97.83%
     * 2023年1月19日09:47:48
     *
     * @param password
     * @return
     */

    private static boolean strongPasswordCheckerII1(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasLow = false;
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        Character preChar = null;
        for (char c : password.toCharArray()) {
            if (preChar != null && preChar == c) {
                return false;
            }
            preChar = c;
            if (!hasSpecialChar && SPECIAL_CHAR_SET.contains(c)) {
                hasSpecialChar = true;
                continue;
            }
            if (!hasNumber && '0' <= c && c <= '9') {
                hasNumber = true;
                continue;
            }
            if (!hasLow && 'a' <= c && c <= 'z') {
                hasLow = true;
                continue;
            }
            if (!hasUpper && 'A' <= c && c <= 'Z') {
                hasUpper = true;
            }
        }
        return hasLow && hasUpper && hasNumber && hasSpecialChar;
    }
}
