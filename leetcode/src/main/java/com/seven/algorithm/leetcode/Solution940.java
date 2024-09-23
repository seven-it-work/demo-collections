/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2022. All rights reserved.
 */

package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author yijialuo
 * @since 2022/10/14 15:15
 */
public class Solution940 {
    public static int distinctSubseqII(String s) {
        return distinctSubseqIISolution1(s);
    }

    /**
     * 作者：京城打工人
     * 链接：https://leetcode.cn/problems/distinct-subsequences-ii/solutions/1890717/bu-tong-by-capital-worker-vga3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int distinctSubseqIISolution1(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        //之前新增的个数
        int[] preCount = new int[26];
        int curAns = 1;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            //新增的个数
            int newCount = curAns;
            //当前序列的个数 = 之前的 + 新增的 - 重复的
            curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
            //记录当前字符的 新增值
            preCount[chs[i] - 'a'] = newCount;
        }
        //减去空串
        return curAns - 1;
    }

    /**
     * 超出内存限制
     * s ="pcrdhwdxmqdznbenhwjsenjhvulyve"
     * <P>思路应该没啥问题，就是耗内存。。。。速度慢</P>
     * 2022/10/14 16:53
     */
    private static int distinctSubseqII1(String s) {
        final HashMap<Character, Integer> charAndIndex = new HashMap<>();
        final HashMap<Integer, List<String>> indexAndStrList = new HashMap<>();
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            final char aChar = chars[i];
            Integer indexWithChar = charAndIndex.get(aChar);
            final List<String> orDefault = new ArrayList<>();
            if (indexWithChar == null) {
                charAndIndex.put(aChar, i);
                orDefault.add(aChar + "");
            } else {
                charAndIndex.put(aChar, i);
            }
            for (int j = Optional.ofNullable(indexWithChar).orElse(0); j < indexAndStrList.size(); j++) {
                final List<String> strings = new ArrayList<>(indexAndStrList.get(j));
                strings.forEach(s1 -> orDefault.add(s1 + aChar));
            }
            indexAndStrList.put(i, orDefault);
        }
        return indexAndStrList.values().stream().mapToInt(List::size).sum();
    }
}
