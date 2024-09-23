package com.seven.algorithm.leetcode;

import java.util.LinkedList;

public class Solution3174 {
    public static void main(String[] args) {
        System.out.println(new Solution3174().clearDigits("ag3"));
    }

    /**
     * 2024-9-5 16:44:43
     * 直接暴力遍历
     * 执行用时分布3ms击败17.92%
     * 复杂度分析消耗内存分布42.18MB击败5.05%
     * 2024-9-5 16:52:16
     *
     * @param s
     * @return
     */
    public String clearDigits(String s) {
        char[] chars = s.toCharArray();
        String[] temp = new String[chars.length];
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= '0' && aChar <= '9') {
                temp[i] = "";
                if (!integers.isEmpty()) {
                    Integer integer = integers.removeFirst();
                    temp[integer] = "";
                }
            } else {
                temp[i] = aChar + "";
                integers.push(i);
            }
        }
        return String.join("", temp);
    }
}
