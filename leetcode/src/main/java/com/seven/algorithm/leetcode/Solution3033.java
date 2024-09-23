package com.seven.algorithm.leetcode;

import com.seven.algorithm.utils.TransformUtils;

public class Solution3033 {
    public static void main(String[] args) {
        System.out.println(TransformUtils.showArrays(
            new Solution3033().modifiedMatrix(TransformUtils.intTwoDimensionalArrays("[[1,2,-1],[4,-1,6],[7,8,9]]"))));
    }

    public int[][] modifiedMatrix(int[][] matrix) {
        if (matrix.length <= 1) {
            return matrix;
        }
        int[] maxData = new int[matrix[0].length];
        for (int[] ints : matrix) {
            for (int j = 0; j < ints.length; j++) {
                maxData[j] = Math.max(ints[j], maxData[j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==-1) {
                    matrix[i][j]=maxData[j];
                }
            }
        }
        return matrix;
    }
}
