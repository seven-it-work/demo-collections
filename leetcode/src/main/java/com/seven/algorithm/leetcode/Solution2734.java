package com.seven.algorithm.leetcode;

public class Solution2734 {
    public static void main(String[] args) {
        System.out.println(new Solution2734().smallestString("aa"));
        System.out.println(new Solution2734().smallestString("cbabc"));
        System.out.println(new Solution2734().smallestString("acbbc"));
        System.out.println(new Solution2734().smallestString("leetcode"));
    }

    public String smallestString(String s) {
        char[] chars = s.toCharArray();
        boolean isAll = true;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar != 'a') {
                isAll = false;
                break;
            }
        }
        if (isAll) {
            chars[chars.length - 1] = 'z';
            return new String(chars);
        }
        boolean isChange = false;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'a') {
                index = i;
                break;
            } else {
                isChange = true;
                chars[i] = --aChar;
            }
        }
        if (isChange) {
            return new String(chars);
        }
        for (int i = index + 1; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == 'a') {
                break;
            } else {
                chars[i] = --aChar;
            }
        }
        return new String(chars);
    }

    public String smallestStringV1(String s) {
        String[] as = s.split("a");
        if (as.length == 0) {
            return s;
        }
        int maxLenIndex = 0;
        for (int i = 1; i < as.length; i++) {
            if (as[maxLenIndex].length() < as[i].length()) {
                maxLenIndex = i;
            } else if (as[maxLenIndex].length() == as[i].length()) {
                // 比较谁的合小
                int sum = as[maxLenIndex].chars().sum();
                int sum1 = as[i].chars().sum();
                if (sum1 < sum) {
                    maxLenIndex = i;
                }
            }
        }
        char[] chars = as[maxLenIndex].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = --chars[i];
        }
        as[maxLenIndex] = new String(chars);
        return String.join("a", as);
    }
}
