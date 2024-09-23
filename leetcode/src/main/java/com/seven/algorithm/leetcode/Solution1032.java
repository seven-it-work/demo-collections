/*
 * Copyright (c) Huawei Technologies Co., Lq. 2023-2023. All rights reserved
 */

package com.seven.algorithm.leetcode;

/**
 * 1032. 字符流 https://leetcode.cn/problems/stream-of-characters/description/
 *
 * @date 2023/3/24 9:10
 */
public class Solution1032 {

    static class StreamChecker extends StreamChecker1 {

        public StreamChecker(String[] words) {
            super(words);
        }

        public boolean query(char letter) {
            return super.query(letter);
        }
    }

    /**
     * 暴力
     * 2023-3-24 09:18:39
     * 时间 936 ms 击败 12.24% 内存 61.5 MB 击败 93.88%
     */
    private static class StreamChecker1 {
        private final String[] words;

        private final StringBuilder stringBuilder = new StringBuilder();

        public StreamChecker1(String[] words) {
            this.words = words;
        }

        public boolean query(char letter) {
            stringBuilder.append(letter);
            String s = stringBuilder.toString();
            for (String word : words) {
                if (s.endsWith(word)) {
                    return true;
                }
            }
            return false;
        }
    }
}
