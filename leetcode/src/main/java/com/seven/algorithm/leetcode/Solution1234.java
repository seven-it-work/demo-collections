package com.seven.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution1234 {
    public static int balancedString(String s) {
        return balancedString1(s);
    }

    /**
     * 2023-2-13 08:48:02
     * <P>题意理解错误，理解成了替换字符串的个数</P>
     *
     * @param s
     * @return
     */
    private static int balancedString1(String s) {
        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();
        characterIntegerHashMap.put('Q', 0);
        characterIntegerHashMap.put('W', 0);
        characterIntegerHashMap.put('E', 0);
        characterIntegerHashMap.put('R', 0);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            characterIntegerHashMap.put(aChar, characterIntegerHashMap.get(aChar) + 1);
        }
        int averaged = s.length() / 4;
        return characterIntegerHashMap.values()
            .stream()
            .filter(size -> size > averaged)
            .mapToInt(size -> size - averaged)
            .sum();
    }
}
