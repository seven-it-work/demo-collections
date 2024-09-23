package com.seven.algorithm.leetcode;

public class Solution1758 {
    public static void main(String[] args) {
        // System.out.println(new Solution1758().minOperations("0100"));// 1
        System.out.println(new Solution1758().minOperations("1111"));// 2
        // System.out.println(new Solution1758().minOperations("10"));// 0
        // System.out.println(new Solution1758().minOperations("10010100"));// 3
    }

    private static int change1(char[] chars) {
        // 第一个尝试不改
        int count = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            char next = chars[i + 1];
            char now = chars[i];
            if (next == now) {
                count++;
                if (now == '0') {
                    chars[i + 1] = '1';
                } else {
                    chars[i + 1] = '0';
                }
            }
        }
        return count;
    }

    private static int change2(char[] chars) {
        // 第一个取反
        if (chars[0] == '0') {
            chars[0] = '1';
        } else {
            chars[0] = '0';
        }
        return change1(chars) + 1;
    }

    public int minOperations(String s) {
        return Math.min(change2(s.toCharArray()), change1(s.toCharArray()));
    }
}
