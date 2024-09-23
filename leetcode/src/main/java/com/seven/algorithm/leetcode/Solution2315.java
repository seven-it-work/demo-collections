package com.seven.algorithm.leetcode;

public class Solution2315 {

    public static int countAsterisks(String s) {
        return countAsterisks1(s);
    }

    /**
     * 2023-1-29 09:23:09
     * 时间 1 ms 击败 100% 内存 39.4 MB 击败 84.8%
     * 2023-1-29 09:28:30
     * @param s
     * @return
     */
    private static int countAsterisks1(String s) {
        boolean isLine = false;
        int result = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '|') {
                isLine = !isLine;
            } else if (!isLine && aChar == '*') {
                result++;
            }
        }
        return result;
    }
}
