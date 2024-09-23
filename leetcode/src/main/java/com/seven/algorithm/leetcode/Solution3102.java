package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

public class Solution3102 {
    public static void main(String[] args) {
        System.out.println(new Solution3102().minimumDistance(
            TransformUtils.intTwoDimensionalArrays("[[3,2],[3,9],[7,10],[4,4],[8,10],[2,7]]")));// 10
    }

    public int minimumDistance(int[][] points) {
        int mMin = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int mMax = 0;
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                } else {
                    mMax = Math.max(distance(points[i], points[j]), mMax);
                }
            }
            mMin = Math.min(mMin, mMax);
        }
        return mMin;
    }

    private int distance(int[] xy1, int[] xy2) {
        return Math.abs(xy1[0] - xy2[0]) + Math.abs(xy1[1] - xy2[1]);
    }
}
