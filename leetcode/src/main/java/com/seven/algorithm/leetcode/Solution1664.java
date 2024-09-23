package com.seven.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution1664 {
    public static int waysToMakeFair(int[] nums) {
        return waysToMakeFair2(nums);
    }

    /**
     * 暴力
     * 超时。。
     */
    private static int waysToMakeFair2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sumOdd = 0;
            int sumEven = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j < i) {
                    if (j % 2 == 0) {
                        sumEven += nums[j];
                    } else {
                        sumOdd += nums[j];
                    }
                } else if (j > i) {
                    if (j % 2 == 0) {
                        sumOdd += nums[j];
                    } else {
                        sumEven += nums[j];
                    }
                }
            }
            if (sumEven == sumOdd) {
                result++;
            }
        }
        return result;
    }

    /**
     * 找规律
     * 待继续分享
     */
    private static int waysToMakeFair1(int[] nums) {
        // 偶数
        ArrayList<Integer> evenNumber = new ArrayList<>();
        // 奇数
        ArrayList<Integer> oddNumber = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenNumber.add(nums[i]);
            } else {
                oddNumber.add(nums[i]);
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> tempEvenNumber = new LinkedList<>(evenNumber);
            LinkedList<Integer> tempOddNumber = new LinkedList<>(oddNumber);
            if (i % 2 == 0) {
                // 删偶数
                tempEvenNumber.remove(i / 2);
            } else {
                // 删奇数
                tempOddNumber.remove(i / 2);
            }
            // 判断相当
            if (tempEvenNumber.stream().mapToInt(Integer::intValue).sum() == tempOddNumber.stream()
                .mapToInt(Integer::intValue)
                .sum()) {
                result++;
            }
        }
        return result;
    }

}
