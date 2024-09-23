package com.seven.algorithm.leetcode;

public class Solution2024 {
    public static void main(String[] args) {
        System.out.println(new Solution2024().maxConsecutiveAnswers("TTFTTFTT", 1));
        // System.out.println(new Solution2024().maxConsecutiveAnswers("TTFF", 1));
        // System.out.println(new Solution2024().maxConsecutiveAnswers("TTFF", 2));
        // System.out.println(new Solution2024().maxConsecutiveAnswers("TFFT", 1));
        // System.out.println(new Solution2024().maxConsecutiveAnswers("TTFTTTTTFT", 1));
    }

    /**
     * 2024-9-2 14:09:17
     * 利用滑动窗口思路：假设全部都是能转换的 即窗口大小为 answerKey.length
     * 如果 这个窗口中的转换次数大于>k 则滑动，如果不能滑动则 窗口大小=answerKey.length-1
     * 直到能够转换为止
     * 2024-9-2 14:45:20 超时。。
     *
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers1(String answerKey, int k) {
        int slidingWindowSize = answerKey.length();
        char[] chars = answerKey.toCharArray();
        while (true) {
            if (slidingWindowSize == 1) {
                return 1;
            }
            int times = (answerKey.length() - slidingWindowSize);
            for (int i = 0; i < times + 1; i++) {
                int f = 0;
                int t = 0;
                boolean isFind = true;
                for (int j = 0; j < slidingWindowSize; j++) {
                    if (chars[j + i] == 'F') {
                        f++;
                    } else {
                        t++;
                    }
                    if (f > k && t > k) {
                        isFind = false;
                        break;
                    }
                }
                if (isFind) {
                    return slidingWindowSize;
                }
            }
            // 整个数组滑动后都没有找到，则窗口大小-1
            slidingWindowSize--;
        }
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0, countT = 0, countF = 0, maxLen = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }

            // 如果窗口中最小字符数量超过k，收缩窗口
            while (Math.min(countT, countF) > k) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
