/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1238. 循环码排列 <a href="https://leetcode.cn/problems/circular-permutation-in-binary-representation/">...</a>
 *
 * @date 2023/2/23 8:51
 */
public class Solution1238 {
    public static List<Integer> circularPermutation(int n, int start) {
        return circularPermutation2(n, start);
    }

    /**
     * 2023-3-2 09:52:06
     * <P>放弃！！就差 首尾循环了！</P>
     */

    private static List<Integer> circularPermutation2(int n, int start) {
        int len = (int) Math.pow(2, n);
        // 先转换二进制
        String[] strings = new String[len];
        // 二进制的和，以及二进制的值
        HashMap<Integer, List<String>> map = new HashMap<>();
        int maxSum = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            String binaryString = Integer.toBinaryString(i);
            maxLen = Math.max(maxLen, binaryString.length());
            strings[i] = "000000000000000000" + binaryString;
            int sum = sumBinaryString(strings[i]);
            maxSum = Math.max(sum, maxSum);
            List<String> orDefault = map.getOrDefault(sum, new ArrayList<>());
            orDefault.add(strings[i]);
            map.put(sum, orDefault);
        }
        // 交换位置
        String temp = strings[0];
        strings[0] = strings[start];
        strings[start] = temp;
        String[] result = new String[len];
        for (int i = 0; i <= maxSum; i++) {
            List<String> remove = map.remove(i);
            int tempI = i;
            while (result[tempI] != null) {
                tempI++;
            }
            for (String s : remove) {
                // 字符格式化
                s = s.substring(s.length() - maxLen);
                result[tempI] = s;
                tempI += 2;
            }
        }
        List<Integer> collect = Arrays.stream(result)
            .map(str -> Integer.parseUnsignedInt(str, 2))
            .collect(Collectors.toList());
        // start的sum
        List<Integer> string = new ArrayList<>();
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            if (strings[0].endsWith(result[i])) {
                string.addAll(collect.subList(i, collect.size()));
                if (i != 0) {
                    string.addAll(collect.subList(0, i));
                }
                return string;
            }
        }
        return string;
    }

    private static int sumBinaryString(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 想象很美好，就是不会
     */
    private static List<Integer> circularPermutation1(int n, int start) {
        String[] byteStrings = new String[2 * n];
        for (int i = 0; i < byteStrings.length; i++) {
            byteStrings[i] = Integer.toBinaryString(i);
        }
        String temp = byteStrings[0];
        byteStrings[0] = Integer.toBinaryString(start);
        byteStrings[start] = temp;
        fillIn(byteStrings);
        List<String> cycle = cycle(Arrays.stream(byteStrings).collect(Collectors.toList()));
        System.out.println(cycle);
        return new ArrayList<>();
    }

    private static List<String> cycle(List<String> byteStrings) {

        ArrayList<String> result = new ArrayList<>();
        if (byteStrings.size() <= 1) {
            return byteStrings;
        }
        result.add(byteStrings.get(0));
        char[] chars = byteStrings.get(0).toCharArray();
        for (int i = 1; i < byteStrings.size(); i++) {
            ArrayList<String> tempStr = new ArrayList<>();
            String s = byteStrings.get(i);
            char[] tempChar = s.toCharArray();
            if (checkIsJustOneNotSame(chars, tempChar)) {
                tempStr.addAll(byteStrings.subList(i + 1, byteStrings.size()));
                List<String> cycle = cycle(tempStr);
                result.addAll(cycle);
            } else {
                tempStr.add(s);
            }
        }
        return result;
    }

    private static boolean checkIsJustOneNotSame(char[] chars, char[] tempChar) {
        boolean hasNotSame = false;
        for (int c1 = 0; c1 < chars.length; c1++) {
            if (chars[c1] != tempChar[c1]) {
                if (hasNotSame) {
                    return false;
                }
                hasNotSame = true;
            }
        }
        return hasNotSame;
    }

    private static void fillIn(String[] byteStrings) {
        int maxLen = Arrays.stream(byteStrings).map(String::length).max(Integer::compareTo).orElse(0);
        for (int i = 0; i < byteStrings.length; i++) {
            if (byteStrings[i].length() < maxLen) {
                for (int j = 1; j < maxLen; j++) {
                    byteStrings[i] = "0" + byteStrings[i];
                }
            }
        }
    }
}
