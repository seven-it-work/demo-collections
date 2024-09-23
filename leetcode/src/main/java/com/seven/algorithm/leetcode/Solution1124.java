package com.seven.algorithm.leetcode;

public class Solution1124 {
    public static int longestWPI(int[] hours) {
        return longestWPI1(hours);
    }

    /**
     * 2023-2-14 08:40:32
     * 思路有问题，解不了
     *
     * @param hours
     * @return
     */
    private static int longestWPI1(int[] hours) {
        int maxTimePeriod = 0;
        for (int startIndex = 0; startIndex < hours.length; startIndex++) {
            int tempTimePeriod = 0;
            int tiredDays = 0;
            int notTiredDays = 0;
            for (int index = startIndex; index < hours.length; index++) {
                if (hours[index] > 8) {
                    tiredDays++;
                } else {
                    notTiredDays++;
                }
                if (tiredDays > notTiredDays - 1) {
                    // 继续
                    tempTimePeriod++;
                } else {
                    notTiredDays--;
                    break;
                }
            }
            // 取最大包容
            tempTimePeriod = Math.min(tempTimePeriod + tiredDays - notTiredDays - 1, hours.length);
            maxTimePeriod = Math.max(maxTimePeriod, tempTimePeriod);
        }
        return maxTimePeriod;
    }
}
